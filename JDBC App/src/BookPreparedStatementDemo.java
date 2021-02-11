import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class BookPreparedStatementDemo {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Scanner scnr=new Scanner(System.in);
		int id;
		String name,author;
		float price;
		
		Connection connection=null;
		//Register the driver		
		Class.forName("com.mysql.jdbc.Driver");
			
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		PreparedStatement pstmt=connection.prepareStatement("insert into  book values(?,?,?,?)");
		
		/*pstmt.setInt(1,1003);
		pstmt.setString(2,"Computer Arch");
		pstmt.setString(3,"Morris Mono");
		pstmt.setFloat(4,700.50f);*/
		
		System.out.println("Enter book details - id, name, author, price");
		id=scnr.nextInt();
		scnr.nextLine();
		name=scnr.nextLine();
		author=scnr.nextLine();
		price=scnr.nextFloat();
		scnr.nextLine();
		
		pstmt.setInt(1,id);
		pstmt.setString(2,name);
		pstmt.setString(3,author);
		pstmt.setFloat(4,price);
		
		int rowCount=pstmt.executeUpdate();
		System.out.println(rowCount+" Records inserted");
		
		//connection.commit();
		connection.close();
		

	}

}
