package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vishwa Prasad
 */
public class JDBC_Update 
{

    Statement stmt; 
    
    //function to update record for selected row
    public static void Table_Update(int emp_id) throws SQLException
    {



    }
    public static void main(String args[]) throws Exception
    {
        JDBC_getconnection();
    }

}
