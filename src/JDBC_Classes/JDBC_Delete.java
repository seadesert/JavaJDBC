package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
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
    public static void Table_Delete(int emp_id) throws SQLException
    {



    }
    
    //function to delete multiple records
    public static void Table_Delete(int[] emp_id) throws SQLException
    {



    }
    
    //function to delete all records
    public static void Table_Delete() throws SQLException
    {



    }
        public static void main(String args[]) throws Exception
    {
        JDBC_getconnection();
    }


}
