package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Admin extends JFrame {
	static final String DB_URL = "jdbc:mysql://localhost:3306/bus_database";
	static final String USER = "root";
	static final String PASS = "9999";
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setFont(new Font("Arial", Font.BOLD, 15));
		setTitle("Hello Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(40, 42, 146, 23);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setForeground(Color.WHITE);
		t1.setBackground(Color.DARK_GRAY);
		t1.setBounds(76, 73, 146, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Password");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 104, 205, 22);
		contentPane.add(lblNewLabel_1);
		
		t2 = new JTextField();
		t2.setForeground(Color.WHITE);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t2.setBackground(Color.DARK_GRAY);
		t2.setBounds(76, 137, 146, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JButton b1 = new JButton("Log In");
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1;
				String text2;
				
				int ID , PW;
				int ID_DB =0 , PW_DB = 0;
				String name_DB;
				text1 = t1.getText();
				text2 = t2.getText();
				
				try {
					ID = Integer.parseInt(text1);
					PW = Integer.parseInt(text2);
					String Query ="SELECT * FROM admin WHERE admin_ID="+ID;
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
							 ResultSet rs = stmt.executeQuery(Query);
					      ) {	
						while(rs.next()) {
							ID_DB = rs.getInt("admin_ID");
							PW_DB = rs.getInt("pw");
							name_DB = rs.getString("name");
						    System.out.println(name_DB +ID_DB+PW_DB);
						}
						    rs.close();
						    stmt.close();
						    if(PW == PW_DB)
						    {
						    	AdminFunctions frame1 = new AdminFunctions();
						    	frame1.setVisible(true);
						    }
						    else {
						    	JOptionPane.showMessageDialog( null , "WRONG PASSWORD OR WRONG ID");
						    }
					      } catch (SQLException e3) {
					         e3.printStackTrace();
					      } 
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog( null , e1.getMessage());
				}
				
			}
		});
		b1.setBounds(177, 187, 89, 23);
		contentPane.add(b1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\20109\\Desktop\\PAV5f113e_stud01.jpg"));
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_2);
	}
}
