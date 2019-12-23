package com.automatizacion.test;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import java.awt.Choice;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;

 
public class Index extends JFrame  {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txt4;
	private JLabel lblSeleccioneElTipo;
	private JComboBox cb1;
	private JLabel lb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SEVEN\\eclipse-workspace\\PruebasAutomaticas\\src\\test\\resources\\icon.png"));
		setTitle("Pruebas el Brayan");
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txt1 = new JTextField();
		txt1.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		txt1.setForeground(Color.BLUE);
		txt1.setBounds(10, 111, 400, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btnNewButton = new JButton("Test\r\n");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 20, 147));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lb1.setForeground(Color.RED);
				if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || cb1.getSelectedItem().equals("Seleccione el tipo de test")  ) {
					
					lb1.setVisible(true);
					lb1.setText("Faltan campos por llenar, verificar");
				} else {
					lb1.setVisible(false);
					String tipo = cb1.getSelectedItem().toString();
					String pagina = txt1.getText();
					String ruta = txt2.getText();
					String hoja = txt3.getText();
					int row = Integer.parseInt(txt4.getText());
					
					switch (tipo) {
					case "Busqueda Google":
						CargarExcel et = new CargarExcel(pagina,ruta,row-1,hoja);
						try {
							et.setUp();
							et.test();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							try {
								et.tearDown();
								lb1.setVisible(true);
								lb1.setText("No se encontraron los datos en el excel");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
						}
						break;
						
					case "Login Gmail":
						Singup et2 = new Singup(pagina,ruta,row-1,hoja);
						try {
							et2.setUp();
							et2.test();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
							try {
								et2.tearDown();
								lb1.setVisible(true);
								lb1.setText("No se encontraron los datos en el excel");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
						}
						break;

					default:
						lb1.setVisible(true);
						lb1.setText("No se encontro el tipo de test que selecciono");
						break;
					}
					
				}
			}
		});
		btnNewButton.setBounds(22, 406, 400, 32);
		contentPane.add(btnNewButton);
		
		txt2 = new JTextField();
		txt2.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		txt2.setForeground(Color.BLACK);
		txt2.setBounds(10, 169, 400, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		txt3.setForeground(Color.BLACK);
		txt3.setBounds(10, 231, 400, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite la url de la pagina\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 86, 160, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite la ruta del excel mas el nombre del archivo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 144, 400, 14);
		contentPane.add(lblNewLabel_1);
		
		
		cb1 = new JComboBox();
		cb1.setToolTipText("Login\r\n");
		cb1.setBounds(10, 337, 400, 20);
		contentPane.add(cb1);
		cb1.addItem("Seleccione el tipo de test");
		cb1.addItem("Busqueda Google");
		cb1.addItem("Login Gmail");
		
		lblNewLabel_2 = new JLabel("Digite el nombre de la hoja del excel");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 206, 400, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Digite la fila en la cual desea comenzar el test");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 256, 400, 14);
		contentPane.add(lblNewLabel_3);
		
		txt4 = new JTextField();
		txt4.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		txt4.setForeground(Color.BLACK);
		txt4.setBounds(10, 281, 400, 20);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		lblSeleccioneElTipo = new JLabel("Seleccione el tipo de test que desea realizar");
		lblSeleccioneElTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccioneElTipo.setBounds(10, 312, 400, 14);
		contentPane.add(lblSeleccioneElTipo);
		
		lb1 = new JLabel("New label");
		lb1.setBackground(Color.RED);
		lb1.setBounds(10, 368, 400, 14);
		lb1.setVisible(false);
		contentPane.add(lb1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 20, 147));
		panel.setBounds(0, 0, 445, 46);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("Prototipo 1");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel_4);
	}
}
