import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    static Connection con = null;
     static Connection getDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee","postgres","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
