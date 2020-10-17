
package JDBC_Classes;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBC_Connection {


    public static void JDBC_getconnection() throws Exception 
    {
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/mydb";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
    }
    
}
