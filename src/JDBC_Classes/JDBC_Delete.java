package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nagashree MK
 */
public class JDBC_Delete 
{

    Statement stmt; 
    
    //function to Delete a selected record
    public static void Table_Delete(int emp_id) throws SQLException, Exception
    {
             String sql = "delete from emp where emp_ID =" + emp_id;
            
            Connection conn = JDBC_getconnection(); 
            Statement stmt = conn.createStatement(); 

          stmt.executeUpdate(sql);
          System.out.println("Record deleted successfully");

    }


    
    
    //function to delete multiple records
    public static void Table_Delete(int[] emp_id) throws SQLException
    {


          System.out.println("Record(s) deleted successfully");
    }
    
    //function to delete all records
    public static void Table_Delete() throws SQLException, Exception
    {
        String sql = "delete from emp";
            
            Connection conn = JDBC_getconnection(); 
            Statement stmt = conn.createStatement(); 
            stmt.executeUpdate(sql);
          System.out.println("All Record(s) deleted successfully");

    }
        public static void main(String args[]) throws Exception
    {
        //CLI_Interface here
    }


}
