/**
 *
 * @author Ruchi
 */
import java.sql.*;
import java.util.Scanner;
public class SQL_injection_prevent {
    public static void main(String[] args) throws SQLException {
        Scanner in=new Scanner(System.in);
		String username,password;
		System.out.println("enter the user name");
		username=in.nextLine();
		System.out.println("enter the password");
		password=in.nextLine();
		Connection con=null;
               try 
		{       Class.forName("com.mysql.jdbc.Driver");
                       System.out.println("Connecting to database...");
			String url = "jdbc:mysql://localhost:3306/test";
			con = DriverManager.getConnection(url,"root","");                   			
           		PreparedStatement ps = con.prepareStatement("select * from sql_injection where name =? and password =?");
                          ps.setString(1,username);
                        ps.setString(2,password);
                        ResultSet rs = ps.executeQuery();
                       
                        while(rs.next())
                        {
                            System.out.print(rs.getString("name"));
                            System.out.println("\t"+rs.getString("password"));
                        }
                         
	         } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("data base file exception"+ex);
                 }
   }
    

}