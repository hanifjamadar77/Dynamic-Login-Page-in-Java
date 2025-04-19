import java.sql.*;
public class UpdateDB {
    public static void main(String[] args) {
        try {
<<<<<<< HEAD
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/myloginpage", "root", "");
=======
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myloginpage", "root", "");
>>>>>>> bcc31edbaac87d3722b772c6fdde4df181d36717

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
