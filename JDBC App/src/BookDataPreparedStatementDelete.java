import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDataPreparedStatementDelete {
	
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Scanner scnr=new Scanner(System.in);
		int id;
		
		Connection connection=null;
		//Register the driver		
		Class.forName("com.mysql.jdbc.Driver");
			
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		PreparedStatement pstmt=connection.prepareStatement("delete from  book where id=?");
	
		
		System.out.println("Enter book details -id");
		
		id=scnr.nextInt();
		scnr.nextLine();
		
		pstmt.setInt(1,id);
		
		
		int rowCount=pstmt.executeUpdate();
		System.out.println(rowCount+" Records deleted");
		
		//connection.commit();
		//connection.close();
		

	}

}



