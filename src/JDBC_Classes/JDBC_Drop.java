package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nagashree MK
 */
public class JDBC_Drop {

    
    public static void main(String[] args) throws SQLException, Exception {



      Connection conn = JDBC_getconnection();
      System.out.println("Connected database successfully...");
      System.out.println("Deleting database...");
      Statement stmt = conn.createStatement();
      
      String sql = "DROP DATABASE emp";
      stmt.executeUpdate(sql);
      System.out.println("Database deleted successfully...");


    
    }
}
