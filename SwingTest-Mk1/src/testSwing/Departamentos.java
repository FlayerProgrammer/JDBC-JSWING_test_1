package testSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Departamentos {
	Connection connection = null;

	public Departamentos() throws SQLException {

		connection = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");

	}

	public void create(Departamento dep) throws SQLException {

		String sql = "INSERT INTO DEPARTAMENTOS VALUES (?,?,?)";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setInt(1, dep.getDept_no());
		sentencia.setString(2, dep.getDnombre());
		sentencia.setString(3, dep.getLoc());
		int filas;//
		filas = sentencia.executeUpdate();
		System.out.println("Filas afectadas: " + filas);
	}

	public int Update(Departamento dep) throws SQLException {
		int filas;
		String sql = "Update departamentos set loc =?,dnombre=? where dept_no=?";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setString(1, dep.getLoc());
		sentencia.setString(2, dep.getDnombre());
		sentencia.setInt(3, dep.getDept_no());
		filas = sentencia.executeUpdate();
		return filas;

	}

	public List<Departamento> ReadAll() throws SQLException {
		List<Departamento> deps = new ArrayList<Departamento>();
		String sql = "select * from departamentos ";
		Statement sentencia = connection.createStatement();
		sentencia.execute(sql);
		ResultSet rs = sentencia.getResultSet();
		while (rs.next()) {
			Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("Loc"));
			deps.add(dep);
		}
		return deps;
	}

	public Departamento Read(String nombre) throws SQLException {

		String sql = "select * from departamentos where dnombre= ? ";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setString(1, nombre);
		sentencia.execute();
		ResultSet rs = sentencia.getResultSet();
		Departamento dep=null;
		while(rs.next()) {
			dep=new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("Loc"));
		}
		return dep;
	}

	public void Delete(int dept_no) throws SQLException {

		String sql = "Delete from Departamentos WHERE dept_no= ?";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setInt(1, dept_no);
		sentencia.execute();

	}

}
