package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vinay M
 */
public class JDBC_Create 
{
     private static final String EMPLOYEE_TABLE = "create table rmp( "
      + " Emp_ID INT PRIMARY KEY, Emp_Name VARCHAR(20), Emp_Address VARCHAR(20), "
      + "   Emp_Branch VARCHAR(20), Emp_Salary FLOAT )"; 
    
    //function to create Table
    public static void Table_Create() throws SQLException, Exception
    {

      Connection conn = JDBC_getconnection();
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(EMPLOYEE_TABLE);
      System.out.println("CreateEmployeeTable: main(): table created.");
    }     
        public static void main(String args[]) throws Exception
    {
        Table_Create();
    }
}

