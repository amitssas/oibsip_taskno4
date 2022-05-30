import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddBooksql {
	public static int save(String bookid,String name,String author,String publisher,int year){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO allbooks(bookid,name,author,publisher,year) values(?,?,?,?,?)");
			ps.setString(1,bookid);
			ps.setString(2,name);
			ps.setString(3,author);
			ps.setString(4,publisher);
			ps.setInt(5,year);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
