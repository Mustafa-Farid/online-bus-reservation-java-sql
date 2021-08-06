package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PassengerFunctions extends JFrame {
	static final String DB_URL = "jdbc:mysql://localhost:3306/bus_database";
	static final String USER = "root";
	static final String PASS = "9999";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerFunctions frame = new PassengerFunctions();
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
	public PassengerFunctions() {
		setTitle("Hello");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Order Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order frame = new Order();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setBounds(86, 181, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID;
				int id , ID_DB = 0;
				ID = JOptionPane.showInputDialog("please enter your ID");
				String Query ="SELECT passengerID FROM orders WHERE passengerID="+ID;

				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(Query);
				      ) {	
					
					id = Integer.parseInt(ID);
					
					while(rs.next()) {
						ID_DB = rs.getInt("passengerID");
					    
					}
					    
					    if(id == ID_DB)
					    {
					    	String sql = "Delete FROM orders WHERE passengerID = "+id ;
					    	stmt.executeUpdate(sql);
					    	JOptionPane.showMessageDialog(null, "Done ! deleted");
					    }
					    else {
					    	JOptionPane.showMessageDialog( null , " WRONG ID");
					    }
					
					
				      } catch (SQLException e1 ) {
				    	 JOptionPane.showMessageDialog(null, "Error has happened !");
				         e1.printStackTrace();
				      }
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Error has happened !");
				}
			}
		});
		btnNewButton_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1.setBounds(248, 181, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\20109\\Desktop\\1st semester\\d17fb32a501c5121be95c0d6ed232272.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}

}
