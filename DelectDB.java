import java.sql.*;
public class DelectDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myloginpage", "root", "");

           // PreparedStatement stmt = con.prepareStatement("insert into userlogin values(?,?,?,?)");
             final String QUERY = "SELECT username, email, password, country FROM userlogin";
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM userlogin " + "WHERE  username";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
