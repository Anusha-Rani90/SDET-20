package pac2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertARowValueUsingTryCatchTest {

	public static void main(String[] args) throws Throwable {
		Connection connection=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apple", "root", "root");
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery("select * from colour");
		
		while(result.next())
		{
			System.out.println(result.getString(1) + "\t" + result.getString(2));
			
		}
		System.out.println("**************************");

		ResultSet descTable = statement.executeQuery("show databases");
		while(descTable.next())
		{
			System.out.println(descTable.getString(1));
			
		}
		ResultSet descColour = statement.executeQuery("desc colour");
		while(descColour.next())
		{
			System.out.println(descColour.getString(1));
			
		}
		//System.out.println(descColour);

		//System.out.println("**************************");


		System.out.println("**************************");
//		ResultSet insert = statement.executeQuery("insert into colour values('10', 'sweet')");
//		System.out.println(insert);
//		System.out.println("****************************");
//		System.out.println(descTable);
	}catch(Exception e)
		{
			
		}
		finally {
		connection.close();
	}
	}

}
