import java.sql.*;
public class UpdateDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myloginpage", "root", "");

            PreparedStatement stmt = con.prepareStatement("insert into userlogin values(?,?,?,?)");

            stmt.setString(1, "Motu");
            stmt.setString(2, "motu@gmail.com");
            stmt.setString(3, "12345");
            stmt.setString(4, "india");
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
