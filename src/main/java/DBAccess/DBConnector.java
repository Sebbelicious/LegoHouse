/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author s_ele
 */
public class DBConnector {
    //    private static final String URL = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String IP = "138.68.68.197"; 
    private static final int PORT = 3306;
    public static final String DATABASE = "LegoHouse"; 
    private static final String URL = "jdbc:mysql://"+ IP + ":" + PORT + "/" + DATABASE;
    private static final String USERNAME = "sebastian";
    private static final String PASSWORD = "Hvadfanden10";

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
