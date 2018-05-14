package testSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Empleados {
	Connection connection = null;
	private List<Empleado> empleados;

	public Empleados() throws SQLException {

	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
		
	
	}

	public void create(Empleado emp) throws SQLException {

		String sql = "INSERT INTO EMPLEADOS VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		int filas;//
		sentencia.setInt(1, emp.getEmp_no());
		sentencia.setString(2, emp.getApellido());
		sentencia.setString(3, emp.getOficio());
		sentencia.setInt(4, emp.getDir());
		sentencia.setDate(5, emp.getFecha_alt());
		sentencia.setFloat(6, emp.getSalario());
		sentencia.setFloat(7, emp.getComision());
		sentencia.setInt(8, emp.getDept_no());
		filas = sentencia.executeUpdate();
		System.out.println("Filas afectadas: " + filas);
	}

	public int Update(Empleado emp) throws SQLException {
		int filas;
		String sql = "UPDATE EMPLEADOS SET apellido=?,oficio=?,dir=?,fecha_alt=?, "
				+ "salario=?,comision=?,dept_no=? where emp_no=?";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setInt(8, emp.getEmp_no());
		sentencia.setString(1, emp.getApellido());
		sentencia.setString(2, emp.getOficio());
		sentencia.setInt(3, emp.getDir());
		sentencia.setDate(4, emp.getFecha_alt());
		sentencia.setFloat(5, emp.getSalario());
		sentencia.setFloat(6, emp.getComision());
		sentencia.setInt(7, emp.getDept_no());
		filas = sentencia.executeUpdate();
		return filas;

	}

	public List<Empleado> ReadAll() throws SQLException {

		ArrayList<Empleado> empleados =new ArrayList<Empleado>();
		String sql = "select * from empleados ";
		Statement sentencia = connection.createStatement();
		sentencia.execute(sql);
		ResultSet rs = sentencia.getResultSet();
		while (rs.next()) {
			Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"),
					rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"),
					rs.getFloat("comision"), rs.getInt("emp_no"));
			empleados.add(emp);
		}
		return empleados;
	}

	public Empleado Read(String apellido) throws SQLException {
		Empleado emp = null;
		String sql = "select * from empleados where apellido= ? ";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setString(1, apellido);
		sentencia.execute();
		ResultSet rs = sentencia.getResultSet();
		while (rs.next()) {
			emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"),
					rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"),
					rs.getInt("dept_no"));

		}
		return emp;
	}

	public void Delete(int emp_no) throws SQLException {

		String sql = "Delete from empleados WHERE emp_no= ?";
		PreparedStatement sentencia = connection.prepareStatement(sql);
		sentencia.setInt(1, emp_no);
		sentencia.execute();

	}

}
