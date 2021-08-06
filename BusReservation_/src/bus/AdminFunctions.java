package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

public class AdminFunctions extends JFrame {
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
					AdminFunctions frame = new AdminFunctions();
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
	public AdminFunctions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 250, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton b1 = new JButton("Add Trip");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="" , id , endDest,startDest , adminID,busID;
				try {
				id = JOptionPane.showInputDialog("enter trip id");
				endDest = JOptionPane.showInputDialog("enter end destination");
				startDest = JOptionPane.showInputDialog("enter start destination");
				adminID = JOptionPane.showInputDialog("enter admin ID");
				busID = JOptionPane.showInputDialog("enter bus ID");
				sql = "INSERT INTO trips VALUES ("+Integer.parseInt(id)+","+"'"+endDest+"'"+","+"'"+startDest+"'"+","+Integer.parseInt(adminID)+","+Integer.parseInt(busID)+")";
				System.out.println(sql);
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				      ) {		      
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Done ! inserted");
				      } catch (SQLException e1) {
				    	 JOptionPane.showMessageDialog(null, "Error has happened");
				         e1.printStackTrace();
				      }
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Error wrong inputs !");
				}
			}
		});
		b1.setBounds(89, 28, 113, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Add Bus");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="" , id , seatNum,driverID , adminID;
				try {
				id = JOptionPane.showInputDialog("enter bus id");
				seatNum = JOptionPane.showInputDialog("enter seat numbers of bus");
				driverID = JOptionPane.showInputDialog("enter driver id of the bus");
				adminID = JOptionPane.showInputDialog("enter admin ID");
				
				sql = "INSERT INTO bus VALUES ("+Integer.parseInt(id)+","+Integer.parseInt(seatNum)+","+Integer.parseInt(driverID)+","+Integer.parseInt(adminID)+")";
				System.out.println(sql);
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				      ) {		      
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Done ! inserted");
				      } catch (SQLException e1) {
				    	 JOptionPane.showMessageDialog(null, "Error has happened");
				         e1.printStackTrace();
				      }
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Error wrong inputs !");
				}
				
			}
		});
		b2.setBounds(89, 92, 113, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Add ticket");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="" , id , date,amount , tripID, adminID,pID;
				try {
				id = JOptionPane.showInputDialog("enter ticket id");
				date = JOptionPane.showInputDialog("enter date ");
				amount = JOptionPane.showInputDialog("enter amount of tickets");
				tripID = JOptionPane.showInputDialog("enter trip id o");
				//pID = JOptionPane.showInputDialog("enter passenger id ");
				adminID = JOptionPane.showInputDialog("enter admin ID");
				
				sql = "INSERT INTO tickets VALUES ("+Integer.parseInt(id)+","+"'"+date+"'"+","+Integer.parseInt(amount)+","+Integer.parseInt(tripID)+","+null+","+Integer.parseInt(adminID)+")";
				System.out.println(sql);
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				      ) {		      
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Done ! inserted");
				      } catch (SQLException e1) {
				    	 JOptionPane.showMessageDialog(null, "Error has happened");
				         e1.printStackTrace();
				      }
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Error wrong inputs !");
				}
			}
		});
		b3.setBounds(89, 154, 113, 23);
		contentPane.add(b3);
		
		JButton b4 = new JButton("Add Driver");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="" , id , name, adminID;
				try {
				id = JOptionPane.showInputDialog("enter driver id");
				name = JOptionPane.showInputDialog("enter name of the driver ");
				adminID = JOptionPane.showInputDialog("enter admin ID");
				
				sql = "INSERT INTO drivers VALUES ("+Integer.parseInt(id)+","+"'"+name+"'"+","+Integer.parseInt(adminID)+")";
				System.out.println(sql);
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				      ) {		      
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Done ! inserted");
				      } catch (SQLException e1) {
				    	 JOptionPane.showMessageDialog(null, "Error has happened");
				         e1.printStackTrace();
				      }
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Error wrong inputs !");
				}
			}
		});
		b4.setBounds(89, 213, 113, 23);
		contentPane.add(b4);
		
		JButton btnNewButton = new JButton("Delete Bus");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID;
				int id , ID_DB = 0;
				ID = JOptionPane.showInputDialog("please enter bus ID");
				String Query ="SELECT bus_ID FROM bus WHERE bus_ID="+ID;

				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(Query);
				      ) {	
					
					id = Integer.parseInt(ID);
					
					while(rs.next()) {
						ID_DB = rs.getInt("bus_ID");
					    
					}
					    
					    if(id == ID_DB)
					    {
					    	String sql = "Delete FROM bus WHERE bus_ID = "+id ;
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
		btnNewButton.setBounds(254, 92, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteTrip = new JButton("Delete Trip");
		btnDeleteTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID;
				int id , ID_DB = 0;
				ID = JOptionPane.showInputDialog("please enter trip ID");
				String Query ="SELECT trips_ID FROM trips WHERE trips_ID="+ID;

				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(Query);
				      ) {	
					
					id = Integer.parseInt(ID);
					
					while(rs.next()) {
						ID_DB = rs.getInt("trips_ID");
					    
					}
					    
					    if(id == ID_DB)
					    {
					    	String sql = "Delete FROM trips WHERE trips_ID = "+id ;
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
		btnDeleteTrip.setBounds(254, 28, 113, 23);
		contentPane.add(btnDeleteTrip);
		
		JButton btnDeleteTicket = new JButton("Delete Ticket");
		btnDeleteTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID;
				int id , ID_DB = 0;
				ID = JOptionPane.showInputDialog("please enter ticket ID");
				String Query ="SELECT ticket_ID FROM tickets WHERE ticket_ID="+ID;

				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(Query);
				      ) {	
					
					id = Integer.parseInt(ID);
					
					while(rs.next()) {
						ID_DB = rs.getInt("ticket_ID");
					    
					}
					    
					    if(id == ID_DB)
					    {
					    	String sql = "Delete FROM tickets WHERE ticket_ID = "+id ;
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
		btnDeleteTicket.setBounds(254, 154, 113, 23);
		contentPane.add(btnDeleteTicket);
		
		JButton btnDeleteDriver = new JButton("Delete Driver");
		btnDeleteDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID;
				int id , ID_DB = 0;
				ID = JOptionPane.showInputDialog("please enter Driver ID");
				String Query ="SELECT driver_ID FROM drivers WHERE driver_ID="+ID;

				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(Query);
				      ) {	
					
					id = Integer.parseInt(ID);
					
					while(rs.next()) {
						ID_DB = rs.getInt("driver_ID");
					    
					}
					    
					    if(id == ID_DB)
					    {
					    	String sql = "Delete FROM drivers WHERE driver_ID = "+id ;
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
		btnDeleteDriver.setBounds(254, 213, 113, 23);
		contentPane.add(btnDeleteDriver);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 3, 4);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Trips", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(67, 11, 322, 56);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Buses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(67, 78, 322, 56);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tickets", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(67, 140, 322, 56);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Drivers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(67, 199, 322, 51);
		contentPane.add(panel_4);
	}
}
