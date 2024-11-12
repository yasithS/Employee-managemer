import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection createDBConnection() {

        try{
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // get connection
            String url = "jdbc:mysql://localhost:3306/employeev1";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return con;

    }

}
