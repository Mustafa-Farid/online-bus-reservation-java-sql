package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Order extends JFrame {
	static final String DB_URL = "jdbc:mysql://localhost:3306/bus_database";
	static final String USER = "root";
	static final String PASS = "9999";
	ArrayList<String> des = new ArrayList<String>();
	String[] desArr ;
	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery("SELECT endDes FROM trips");
		      ) {	
			while(rs.next()) {
				des.add(rs.getString("endDes"));
				
			}
			
			desArr = new String[des.size()];
			for(int i=0; i < des.size(); i++){       
	            desArr[i] = des.get(i);       
	        }			
			
		      } catch (SQLException e3) {
		         e3.printStackTrace();
		      }
	
		JComboBox cb = new JComboBox(desArr);
		cb.addActionListener(null);
		cb.setBounds(297, 115, 127, 22);
		contentPane.add(cb);
		
		JLabel lblNewLabel = new JLabel("Please Select Your Destination");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 113, 231, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val,sql;
				int tripID =0, passengerID;
				int order_ID = 0;
				int amount = 0;
				val = (String) cb.getSelectedItem();
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
						 
				      ) {	
					passengerID = Integer.parseInt(t1.getText());
					ResultSet rs = stmt.executeQuery("SELECT trips_ID FROM trips WHERE endDes = "+"'"+val+"'");
					while(rs.next()) {
					tripID = rs.getInt("trips_ID");				
					}
					 ResultSet rs2 = stmt.executeQuery("SELECT amount FROM tickets WHERE tripID = "+tripID);
				        while(rs2.next())
				        {
				        	amount = rs2.getInt("amount");
				        	
				        }
				        if (amount <=0)
				        {
				        	return ;
				        }
				        
				        else {
				        	amount--;
				        	sql ="UPDATE tickets SET amount ="+amount+" WHERE tripID = "+tripID ;					
							stmt.executeUpdate(sql);
				        }
				        
					
					// to get the last id number
					ResultSet rset = stmt.executeQuery("SELECT order_ID FROM orders");
					 Statement s2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				        rset = s2.executeQuery("select order_ID from orders");
				        rset.afterLast();
				        GETLASTINSERTED:
				        while(rset.previous()){
				            order_ID = rset.getInt("order_ID") ;
				            order_ID++;
				            break GETLASTINSERTED;//to read only the last row
				            
				        }
				       
					sql = "INSERT INTO orders VALUES ("+ ++order_ID +","+passengerID+","+tripID+")";					
					stmt.executeUpdate(sql);				
					JOptionPane.showMessageDialog( null , "DONE ! please save your order ID"+order_ID);
					
				      } catch (SQLException e3) {
				         e3.printStackTrace();
				         JOptionPane.showMessageDialog( null , "ERROR  !");
				      }
				}
				
			
		});
		
		btnNewButton.setBounds(168, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		t1 = new JTextField();
		t1.setBounds(297, 149, 127, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblPleaseReenterYour = new JLabel("Please ReEnter Your ID");
		lblPleaseReenterYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseReenterYour.setBounds(69, 146, 218, 22);
		contentPane.add(lblPleaseReenterYour);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\20109\\Desktop\\PAV5f113e_stud01.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
}
