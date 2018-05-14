package testSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	private JTextArea textArea_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private Empleados empmng = null;
	private Departamentos depmng = null;
	private static Empleados empmng2 = null;
	private static Departamentos depmng2 = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextArea textArea_4;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 803);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Create", null, tabbedPane_1, null);

		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Departamentos", null, panel, null);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 145, 209, 20);
		panel.add(textField);

		JLabel label = new JLabel("Localizacion");
		label.setBounds(39, 148, 67, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(39, 104, 46, 14);
		panel.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 101, 209, 20);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 68, 86, 20);
		panel.add(textField_2);

		JLabel label_2 = new JLabel("Dep N\u00BA");
		label_2.setBounds(39, 71, 46, 14);
		panel.add(label_2);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					depmng = new Departamentos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Departamento dep = new Departamento(Integer.parseInt(textField_2.getText()), textField_1.getText(),
						textField.getText());
				try {
					depmng.create(dep);
					textArea.setText("Departamento creado");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					textArea.setText(e.getMessage());
				}
				depmng = null;

			}
		});
		btnInsertar.setBounds(541, 80, 86, 85);
		panel.add(btnInsertar);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(522, 11, 300, 20);
		panel.add(textArea);

		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Empleados", null, panel_3, null);
		panel_3.setLayout(null);

		JButton button = new JButton("Insertar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					empmng = new Empleados();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date ud = null;
				try {
					ud = df.parse(textField_7.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long ms = ud.getTime();
				Date fecha_alt = new java.sql.Date(ms);
				Empleado emp = new Empleado(Integer.parseInt(textField_3.getText()), textField_4.getText(),
						textField_5.getText(), Integer.parseInt(textField_6.getText()), fecha_alt,
						Float.parseFloat(textField_8.getText()), Float.parseFloat(textField_9.getText()),
						Integer.parseInt(textField_10.getText()));
				try {
					empmng.create(emp);
					textArea_2.setText("Empleado creado");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					textArea_2.setText(e.getMessage());
				}
				empmng = null;
			}
		});
		button.setBounds(540, 94, 86, 85);
		panel_3.add(button);

		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(521, 25, 300, 20);
		panel_3.add(textArea_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(127, 25, 86, 20);
		panel_3.add(textField_3);

		JLabel label_3 = new JLabel("Emp N\u00BA");
		label_3.setBounds(29, 28, 46, 14);
		panel_3.add(label_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(127, 56, 200, 20);
		panel_3.add(textField_4);

		JLabel label_4 = new JLabel("Apellido");
		label_4.setBounds(29, 59, 46, 14);
		panel_3.add(label_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(127, 87, 200, 20);
		panel_3.add(textField_5);

		JLabel label_5 = new JLabel("Oficio");
		label_5.setBounds(29, 90, 46, 14);
		panel_3.add(label_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(127, 118, 86, 20);
		panel_3.add(textField_6);

		JLabel label_6 = new JLabel("Dir");
		label_6.setBounds(29, 121, 46, 14);
		panel_3.add(label_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(127, 149, 200, 20);
		panel_3.add(textField_7);

		JLabel label_7 = new JLabel("Fecha de Alta");
		label_7.setBounds(29, 152, 86, 14);
		panel_3.add(label_7);

		JLabel lblyyyymmdd = new JLabel(" (DD/MM/YYYY)");
		lblyyyymmdd.setBounds(344, 152, 86, 14);
		panel_3.add(lblyyyymmdd);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(127, 180, 200, 20);
		panel_3.add(textField_8);

		JLabel label_8 = new JLabel("Salario");
		label_8.setBounds(29, 183, 67, 14);
		panel_3.add(label_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(127, 211, 200, 20);
		panel_3.add(textField_9);

		JLabel label_9 = new JLabel("Comision");
		label_9.setBounds(29, 214, 67, 14);
		panel_3.add(label_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(127, 242, 200, 20);
		panel_3.add(textField_10);

		JLabel label_10 = new JLabel("Dept N\u00BA");
		label_10.setBounds(29, 245, 67, 14);
		panel_3.add(label_10);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Read", null, panel_1, null);
		panel_1.setLayout(null);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(10, 223, 836, 492);
		panel_1.add(textArea_3);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea_3.setText("");
				if (rdbtnNewRadioButton.isSelected()) {
					List<Empleado> listaemp = new ArrayList<Empleado>();
					try {
						empmng = new Empleados();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						listaemp = empmng.ReadAll();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Iterator<Empleado> iterator = listaemp.iterator(); iterator.hasNext();) {
						Empleado empe = (Empleado) iterator.next();
						textArea_3.append(empe.toString() + "\n");
					}
					empmng = null;
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					List<Departamento> listadep = new ArrayList<Departamento>();
					try {
						depmng = new Departamentos();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						listadep = depmng.ReadAll();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Iterator<Departamento> iterator = listadep.iterator(); iterator.hasNext();) {
						Departamento depa = (Departamento) iterator.next();
						textArea_3.append("Dept_no:" + depa.getDept_no() + "|| Nombre:" + depa.getDnombre() + "|| Loc:"
								+ depa.getLoc() + "\n");
					}

				}
				depmng = null;

			}
		});
		btnNewButton.setBounds(158, 11, 90, 23);
		panel_1.add(btnNewButton);

		rdbtnNewRadioButton = new JRadioButton("Empleado");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnNewRadioButton_1.setSelected(false);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(64, 57, 109, 23);
		panel_1.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Departamentos");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnNewRadioButton.setSelected(false);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(64, 83, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update/Delete", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane_2, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		tabbedPane_2.addTab("Departamento", null, panel_4, null);
		panel_4.setLayout(null);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(135, 68, 86, 20);
		panel_4.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(135, 101, 209, 20);
		panel_4.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(135, 145, 209, 20);
		panel_4.add(textField_13);

		JLabel label_11 = new JLabel("Localizacion");
		label_11.setBounds(58, 148, 67, 14);
		panel_4.add(label_11);

		JLabel label_12 = new JLabel("Dep N\u00BA");
		label_12.setBounds(58, 71, 46, 14);
		panel_4.add(label_12);

		JButton button_1 = new JButton("Update");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					depmng = new Departamentos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Departamento dep = new Departamento(Integer.parseInt(textField_11.getText()), textField_12.getText(),
						textField_13.getText());
				try {
					depmng.Update(dep);
					textArea_4.setText("Departamento actualizado");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				depmng = null;

			}
		});
		button_1.setBounds(560, 80, 86, 41);
		panel_4.add(button_1);

		JLabel label_13 = new JLabel("Nombre");
		label_13.setBounds(58, 104, 46, 14);
		panel_4.add(label_13);

		textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setBounds(541, 11, 300, 20);
		panel_4.add(textArea_4);

		JButton button_2 = new JButton("Delete");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					depmng = new Departamentos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					depmng.Delete(Integer.parseInt(textField_11.getText()));
					textArea_4.setText("\n" + "Departamento borrado");
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				depmng = null;
			}
		});
		button_2.setBounds(560, 132, 86, 41);
		panel_4.add(button_2);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					depmng = new Departamentos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Departamento dep = depmng.Read(textField_12.getText());
					textField_11.setText(String.valueOf(dep.getDept_no()));
					textField_12.setText(dep.getDnombre());
					textField_13.setText(dep.getLoc());

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				depmng = null;

			}
		});
		btnRefresh.setBounds(135, 12, 105, 23);
		panel_4.add(btnRefresh);
		
		JLabel label_24 = new JLabel("(Inserte nombre y haga click en \"Refresh\" para buscar.)");
		label_24.setBounds(74, 43, 322, 14);
		panel_4.add(label_24);

		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("Empleado", null, panel_5, null);
		panel_5.setLayout(null);

		JLabel label_14 = new JLabel("Emp N\u00BA");
		label_14.setBounds(10, 74, 46, 14);
		panel_5.add(label_14);

		JLabel label_15 = new JLabel("Apellido");
		label_15.setBounds(10, 105, 46, 14);
		panel_5.add(label_15);

		JLabel label_16 = new JLabel("Oficio");
		label_16.setBounds(10, 136, 46, 14);
		panel_5.add(label_16);

		JLabel label_17 = new JLabel("Dir");
		label_17.setBounds(10, 167, 46, 14);
		panel_5.add(label_17);

		JLabel label_18 = new JLabel("Fecha de Alta");
		label_18.setBounds(10, 198, 86, 14);
		panel_5.add(label_18);

		JLabel label_19 = new JLabel("Salario");
		label_19.setBounds(10, 229, 67, 14);
		panel_5.add(label_19);

		JLabel label_20 = new JLabel("Comision");
		label_20.setBounds(10, 260, 67, 14);
		panel_5.add(label_20);

		JLabel label_21 = new JLabel("Dept N\u00BA");
		label_21.setBounds(10, 291, 67, 14);
		panel_5.add(label_21);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(108, 288, 200, 20);
		panel_5.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(108, 257, 200, 20);
		panel_5.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(108, 226, 200, 20);
		panel_5.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(108, 195, 200, 20);
		panel_5.add(textField_17);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(108, 164, 86, 20);
		panel_5.add(textField_18);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(108, 133, 200, 20);
		panel_5.add(textField_19);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(108, 102, 200, 20);
		panel_5.add(textField_20);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(108, 71, 86, 20);
		panel_5.add(textField_21);

		JLabel label_22 = new JLabel(" (DD/MM/YYYY)");
		label_22.setBounds(325, 198, 86, 14);
		panel_5.add(label_22);

		JTextArea textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setBounds(502, 71, 300, 20);
		panel_5.add(textArea_5);

		JButton button_3 = new JButton("Update");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					empmng = new Empleados();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date ud = null;
				try {
					ud = df.parse(textField_17.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long ms = ud.getTime();
				Date fecha_alt = new java.sql.Date(ms);
				Empleado emp = new Empleado(Integer.parseInt(textField_21.getText()), textField_20.getText(),
						textField_19.getText(), Integer.parseInt(textField_18.getText()), fecha_alt,
						Float.parseFloat(textField_16.getText()), Float.parseFloat(textField_15.getText()),
						Integer.parseInt(textField_14.getText()));
				try {
					empmng.Update(emp);
					textArea_5.setText("Empleado actualizado");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				empmng = null;
			}
		});
		button_3.setBounds(520, 122, 86, 41);
		panel_5.add(button_3);

		JButton button_4 = new JButton("Delete");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					empmng = new Empleados();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					empmng.Delete(Integer.parseInt(textField_21.getText()));
					textArea_5.setText("Empleado borrado");
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(520, 174, 86, 41);
		panel_5.add(button_4);

		JButton button_5 = new JButton("Refresh");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					empmng = new Empleados();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

					Empleado emp = empmng.Read(textField_20.getText());
					textField_21.setText(String.valueOf(emp.getEmp_no()));
					textField_19.setText(emp.getOficio());
					textField_18.setText(String.valueOf(emp.getDir()));
					textField_17.setText(df.format(emp.getFecha_alt()).toString());
					textField_16.setText(String.valueOf(emp.getSalario()));
					textField_15.setText(String.valueOf(emp.getComision()));
					textField_14.setText(String.valueOf(emp.getDept_no()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				empmng = null;
			}
		});
		button_5.setBounds(176, 11, 127, 23);
		panel_5.add(button_5);
		
		JLabel label_23 = new JLabel("(Inserte apellido y haga click en \"Refresh\" para buscar.)");
		label_23.setBounds(89, 45, 322, 14);
		panel_5.add(label_23);
	}
}
