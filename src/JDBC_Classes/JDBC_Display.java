package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Soundarya
 */
public class JDBC_Display 
{
    ResultSet rs;
    Statement stmt; 
    //Function to Initialize ResultSet
    public static ResultSet Load_ResultSet() throws SQLException, Exception
    {
     
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from emp");
        return rs;
    }
    
    //function to display all rows of table
    public static void Table_Display() throws SQLException, Exception
    {
        ResultSet rs = Load_ResultSet();
        
        while (rs.next()) {
          int id = rs.getInt("emp_ID");
          String name = rs.getString("emp_Name");
                    String address = rs.getString("emp_Address");
        String branch = rs.getString("emp_Branch");
        Float salary = rs.getFloat ("salary");
                    System.out.println("\n" + id+"   "+name+"    "+address+"   "+branch+"    "+salary);
                 }

    }
    
        

}

