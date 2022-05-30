import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	   final static String USER = "root";
	   final static String PASS = "amit";
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library",USER,PASS);
		}catch(Exception e){System.out.println(e);}
		return con;
}
	}
