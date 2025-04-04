import java.sql.*;
public class ResultSetDemo{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myloginpage", "root", "");

            Statement st = con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from userlogin");
            while (rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+"  " + rs.getString(4) + "  ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
