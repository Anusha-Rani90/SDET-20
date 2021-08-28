package pac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertARowValuesTryCatchTest {

	public static void main(String[] args) throws Throwable {
		Connection connection = null;
		try {
			
		//Step 1: Register the driver
			
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2: Establish the connection
		
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apple", "root", "root");
				
		//Step 3: Issue the statement
				
		Statement statement = connection.createStatement();
				
		//Step 4 Insert values into table
				
		int result = statement.executeUpdate("insert into colour values('12','sweet')");
		if(result==1)
			{
				System.out.println("Data is added to database");
			} else {
				System.out.println("Data is not added to database");
			}
		}catch(Exception e)
		{
			
		}
	
 finally {
	 connection.close();
 }
	}

}
