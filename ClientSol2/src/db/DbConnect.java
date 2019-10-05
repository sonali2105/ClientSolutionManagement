package db;
import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement insertClient,getClient,updateClient;
    static {
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            c = DriverManager.getConnection(
//            "jdbc:oracle:thin:@localhost:1521:xe", "clientsoldb9", "clientsoldb9");
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection( 
         "jdbc:mysql://localhost:3306/clientsol","root","incapp");
            st = c.createStatement();
            insertClient=c.prepareStatement(
"insert into client_info (name,gender,dob,country,address,language) values (?,?,?,?,?,?)");
            getClient=c.prepareStatement(
    "select * from client_info where name like ?");
            updateClient=c.prepareStatement(
"update client_info set name=?,gender=?,dob=?,country=?,address=?,language=? where cid=?");
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
