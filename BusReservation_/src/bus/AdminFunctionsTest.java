package bus;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminFunctionsTest {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/bus_database";
	static final String USER = "root";
	static final String PASS = "9999";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String xx = "QQQ";
		String insertdata ="INSERT INTO drivers Values ("+777777+","+"'"+xx+"'"+","+100+")";
	             
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {		      
			stmt.executeUpdate(insertdata);
			
		      } catch (SQLException e1) {
		    	
		         e1.printStackTrace();
		      }
		
		
		int driver_id =0, admin_id =0, ID =777777;
		String name = "";
		String Query ="SELECT * FROM drivers WHERE driver_ID="+ID;
		try {
			
			
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			         Statement stmt = conn.createStatement();
					 ResultSet rs = stmt.executeQuery(Query);
			      ) {	
				
					driver_id = rs.getInt("driver_ID");
					name = rs.getString("name");
					admin_id = rs.getInt("adminID");
					
				    
				
				assertEquals(777777,driver_id);
				assertEquals("QQQ",name);
				assertEquals(100,admin_id);
				fail("fail");
}	
		}
		catch(Exception e)
		{
			
			
		}
	}
}
	

