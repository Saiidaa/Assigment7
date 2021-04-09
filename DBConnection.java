
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        // TODO Auto-generated method stub
        Connection con =null;
        String driver = "com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/Forum";
        String user="root";
        String pwd="root";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con=DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }


}