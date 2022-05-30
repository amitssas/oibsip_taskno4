import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBooksql {
	public static boolean checkBook(String bookid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM allbooks where bookid=?");
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static boolean checkBook2(String bookid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM issuedbooks where bookid=?");
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	
	public static int save(String bookid,String bookname,String username){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO issuedbooks(bookid,bookname,username) values(?,?,?)");
			ps.setString(1,bookid);
			ps.setString(2,bookname);
			ps.setString(3,username);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int returnbook(String bookid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM issuedbooks WHERE bookid=?");
			ps.setString(1,bookid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static String name(String bookid) {
		String name1=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT name FROM allbooks WHERE bookid=?");
			ps.setString(1,bookid);
			ResultSet rs = ps.executeQuery();
			 name1 = rs.getString("name");
			con.close();
		}catch(Exception e){System.out.println(e);}
		return name1;
	}
	
}
