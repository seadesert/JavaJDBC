package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nagashree MK
 */
public class JDBC_Drop 
{

    Statement stmt; 
   
    //function to drop table
    public static void Table_Delete() throws SQLException
    {



    }
    public static void main(String args[]) throws Exception
    {
        JDBC_getconnection();
    }

    

}
