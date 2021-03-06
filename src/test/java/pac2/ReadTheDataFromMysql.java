package pac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadTheDataFromMysql {

	public static void main(String[] args) throws Throwable {
		//step 1 : Register the driver
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//step 2: Establish the connction
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apple", "root", "root");
		
		//step 3: Issue the statement
		
		Statement statement = connection.createStatement();
		
		//step 4: Execute the query 
		ResultSet result = statement.executeQuery("select * from colour");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+ "\t" + result.getString(2));
		}
		
		//Step 4: Close th connection
		connection.close();
	}
}	
