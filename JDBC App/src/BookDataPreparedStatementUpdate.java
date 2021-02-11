import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class BookDataPreparedStatementUpdate {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Scanner scnr=new Scanner(System.in);
		int id;
		float price;
		
		Connection connection=null;
		//Register the driver		
		Class.forName("com.mysql.jdbc.Driver");
			
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		PreparedStatement pstmt=connection.prepareStatement("update book set price=? where id=?");
	
		
		System.out.println("Enter book details - price, id");
		price=scnr.nextFloat();
		scnr.nextLine();
		
		
		id=scnr.nextInt();
		scnr.nextLine();
		
		
		pstmt.setFloat(1,price);
		pstmt.setInt(2,id);
		
		
		int rowCount=pstmt.executeUpdate();
		System.out.println(rowCount+" Records inserted");
		
		//connection.commit();
		//connection.close();
		

	}

}
