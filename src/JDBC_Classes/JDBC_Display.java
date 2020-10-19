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
          int id = rs.getInt("id");
          String name = rs.getString("name");
                    String address = rs.getString("address");
        String branch = rs.getString("branch");
        Float salary = rs.getFloat ("salary");
                    System.out.println(id+"   "+name+"    "+address+"   "+branch+"    "+salary);
                 }

    }
    
     //function to display selected row of table 
    public static void Table_Display(int emp_id) throws SQLException, Exception
    {
       ResultSet rs =  Load_ResultSet();
       String sqlSelectQuery =
                           "SELECT * FROM emp WHERE id = ?";
                
    }
    
    //function to display selected row(s) of table
    //accpets array as a parameter
    public static void Table_Display(int[] emp_id) throws SQLException, Exception
    {
       ResultSet rs = Load_ResultSet();
       ArrayList<Integer> resultList = new ArrayList<Integer>();
while (rs.next()) {
        result = rs.getInt(1); 
        resultList.add(result);
    }
return resultList;
        
    }
}
    
    //TODO: add as many ResultSet functions as possible
