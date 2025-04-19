import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDB {
    public static void main(String[] args) {
        try {
<<<<<<< HEAD
            Class.forName("com.mysql.cj.jdbc.Driver");
=======
            Class.forName("com.mysql.jdbc.Driver");
>>>>>>> bcc31edbaac87d3722b772c6fdde4df181d36717
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practical_18", "root", "");
            Statement s = con.createStatement();
            s.execute("create table employee ( emp_id varchar(10),emp_name varchar(20),emp_address varchar(30) )"); // create a table
            s.execute("insert into employee values(001,'ARman','Delhi')"); 
            ((Statement) s).execute("insert into employee values(002,'Robert','Canada')"); 
            s.execute("insert into employee values(003,'Ahuja','Karnal')"); 
            s.execute("select * from employee"); 
            ResultSet rs = s.getResultSet(); 
            if (rs != null) 
                while ( rs.next() ) 
                {
                    System.out.println("________________________________________" );
                    System.out.println("Id of the employee: " + rs.getString(1) );
                    System.out.println("Name of employee: " + rs.getString(2) );
                    System.out.println("Address of employee: " + rs.getString(3) );
                    System.out.println("________________________________________" );
                }
            s.close(); 
            con.close(); 
        }
        catch (Exception err)
        {
            System.out.println("ERROR: " + err);

        }
    }
    }
