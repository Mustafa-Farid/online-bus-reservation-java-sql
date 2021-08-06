package bus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusReservation {

	static final String DB_URL = "jdbc:mysql://localhost:3306/bus_database";
	static final String USER = "root";
	static final String PASS = "9999";
	
	public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		   
	    	  String sql = "SELECT CURRENT_TIMESTAMP";
	    	  ResultSet rs;
	    	   rs = stmt.executeQuery(sql);
	    	   while (rs.next()) {
					Date date = rs.getDate(1);
					System.out.println(date);
				}
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	      
	      MainScreen frame = new MainScreen();
	      frame.setVisible(true);
	   
	      
	   }

	}


