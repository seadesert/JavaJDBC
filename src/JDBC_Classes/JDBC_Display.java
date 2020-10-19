package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
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
    public static void Load_ResultSet() throws SQLException
    {
        
    }
    
    //function to display all rows of table
    public static void Table_Display() throws SQLException
    {
        Load_ResultSet();

//change
int a = 20;
    }
    
     //function to display selected row of table 
    public static void Table_Display(int emp_id) throws SQLException
    {
        Load_ResultSet();
                
    }
    
    //function to display selected row(s) of table
    //accpets array as a parameter
    public static void Table_Display(int[] emp_id) throws SQLException
    {
        Load_ResultSet();
        
    }
    
    //TODO: add as many ResultSet functions as possible
    
    
    
    
        public static void main(String args[]) throws Exception
    {
        JDBC_getconnection();
    }

}
