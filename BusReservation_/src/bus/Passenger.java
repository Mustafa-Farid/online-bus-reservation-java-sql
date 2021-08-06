package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Passenger extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	static final String DB_URL = "jdbc:mysql://localhost:3306/bus_database";
	static final String USER = "root";
	static final String PASS = "9999";
	private JTextField t5;
	private JTextField t6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Passenger frame = new Passenger();
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
	public Passenger() {
		setTitle("hello Traveller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 250, 455, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello Traveller");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 134, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText , pwText, name_DB ;
				int  ID,PW,ID_DB = 0,PW_DB =0 , ph_DB =0  ;
				idText = t1.getText();
				pwText = t2.getText();
				
				
				try {
					ID = Integer.parseInt(idText);
					PW = Integer.parseInt(pwText);
					String Query ="SELECT * FROM passenger WHERE passenger_ID="+ID;
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();
							 ResultSet rs = stmt.executeQuery(Query);
					      ) {	
						while(rs.next()) {
							ID_DB = rs.getInt("passenger_ID");				
							name_DB = rs.getString("name");
							PW_DB = rs.getInt("password");
							ph_DB = rs.getInt("phone");
						    
						}
						    rs.close();
						    stmt.close();
						    if(PW == PW_DB)
						    {
						    	PassengerFunctions frame = new PassengerFunctions();
						    	frame.setVisible(true);
						    	
						    }
						    else {
						    	JOptionPane.showMessageDialog( null , "WRONG PASSWORD OR WRONG ID");
						    }
					      } catch (SQLException e3) {
					         e3.printStackTrace();
					      } 
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog( null ,"ERROR !!");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(68, 261, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText , pwText, nameText, phoneText ;				
				
				String sql = "";
				try {	
					idText = t5.getText();
					pwText = t6.getText();
					nameText = t3.getText();
					phoneText = t4.getText();
					sql = "INSERT INTO passenger VALUES ("+Integer.parseInt(idText)+","+"'"+nameText+"'"+","+Integer.parseInt(pwText)+","+Integer.parseInt(phoneText)+","+null+")";
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					         Statement stmt = conn.createStatement();			 					
					      ) {	
							stmt.executeUpdate(sql);	
							JOptionPane.showMessageDialog( null , "Regstration Complete, Please sign in");
							t5.setText("");
							t6.setText("");
							t4.setText("");
							t3.setText("");
					      } catch (SQLException e3) {
					         e3.printStackTrace();
					      } 
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog( null , "ERROR !!");
				}
				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setBounds(307, 261, 89, 23);
		contentPane.add(btnNewButton_1);
		
		t1 = new JTextField();
		t1.setBounds(68, 62, 110, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 60, 64, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 102, -202, 414);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PW");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(25, 103, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		t2 = new JTextField();
		t2.setBounds(68, 102, 110, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(214, 63, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		t3 = new JTextField();
		t3.setBounds(286, 62, 110, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(214, 101, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		t4 = new JTextField();
		t4.setBounds(286, 102, 110, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(285, 141, 111, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(285, 188, 111, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(214, 144, 64, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("PW");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(214, 191, 46, 14);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sign In", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 38, 183, 265);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Sign Up", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(203, 38, 205, 265);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\20109\\Desktop\\1st semester\\d17fb32a501c5121be95c0d6ed232272.jpg"));
		lblNewLabel_6.setBounds(0, -13, 439, 325);
		contentPane.add(lblNewLabel_6);
	}
}
