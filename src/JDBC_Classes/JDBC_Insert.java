package JDBC_Classes;


import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arun Sri Krishna
 */
public class JDBC_Insert 
{

    Statement stmt; 
    
    //function to create Table
    public static void Table_Insert() throws SQLException
    {



    }
    
    public static void main(String args[]) throws Exception
    {
        JDBC_getconnection();
    }

}
