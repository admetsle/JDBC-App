import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTableDataReader {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		Statement stmt=null;
		ResultSet rs=null;
		//Register the driver
		Class.forName("com.mysql.jdbc.Driver");
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
		
		stmt=connection.createStatement();
		
		System.out.println("Statement Created");
		
		rs=stmt.executeQuery("Select * from student");
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String address=rs.getString(3);
			System.out.println(id+"\t"+name+"\t"+address);
		}
		System.out.println("Result set value "+rs.next());
		/*rs.close();
		stmt.close();
		connection.close();*/
		
	}

}
