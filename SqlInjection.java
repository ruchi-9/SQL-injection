/**
 *
 * @author Ruchi
 */
import java.sql.*;
import java.util.Scanner;
public class SqlInjection {
    public static void main(String[] args) throws SQLException {
        Scanner in=new Scanner(System.in);
		String username,password;
		System.out.println("enter the user name");
		username=in.nextLine();
		System.out.println("enter the password");
		password=in.nextLine();
		Connection con=null;
                Statement st=null;
                
		try 
		{       Class.forName("com.mysql.jdbc.Driver");
                       System.out.println("Connecting to database...");
			String url = "jdbc:mysql://localhost:3306/test";
			con = DriverManager.getConnection(url,"root","");                   			
           		 st=con.createStatement();
			String sql;
                        sql="select * from sql_injection where name ='"+username+"' and password='"+password+"'" ;
                        ResultSet rs = st.executeQuery(sql);
                       
                        while(rs.next())
                        {
                            System.out.print(rs.getString("name"));
                            System.out.println("\t"+rs.getString("password"));
                        }
                         System.out.println("SQL injection performed get the password with username");
                         
	         } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("data base file exception"+ex);
                 }
    if (st!=null){
       st.close();
    }}
    

}