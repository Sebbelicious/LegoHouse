package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author s_ele
 */
public class DBConnector {
    private static final String IP = "138.68.68.197"; 
    private static final int PORT = 3306;
    public static final String DATABASE = "LegoHouse"; 
    private static final String URL = "jdbc:mysql://"+ IP + ":" + PORT + "/" + DATABASE + "?autoReconnect=true";
    private static final String USERNAME = "legohouseuser";
    private static final String PASSWORD = "ilovelego";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
}
