import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usersql {
	
	public static int save(String regdno,String name,String email,String contact,String password){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO users(regdno,name,email,contact,password) values(?,?,?,?,?)");
			ps.setString(1,regdno);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,contact);
			ps.setString(5,password);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM users where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
