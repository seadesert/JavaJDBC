package JDBC_Classes;


import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Arun Sri Krishna
 */

static int r_count = 1;
public class JDBC_Insert 
{

    
    //function to create Table
    public static void Table_Insert(String[] col_values, String[] col_datatype) throws SQLException, Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();
        
        
        
        String SQL_Statement = "insert into emp values("+ r_count + " ";
        r_count++;
        while(col_values[r_count] != "")
        {
            if(col_datatype[r_count].equals("VARCHAR"))
            {
                SQL_Statement += ",'" + col_values[r_count] + "' ";
            }
            else if (col_datatype[r_count].equals("INTEGER"))
            {
                SQL_Statement += ", " + Integer.parseInt(col_values[r_count]) + " ";
            }
            else if (col_datatype[r_count].equals("FLOAT"))
            {
                SQL_Statement += ", " + Float.parseFloat(col_values[r_count]) + " ";                
            }
            else
            {
                SQL_Statement += ", " + col_values[i] + " ";                 
            }
            i++;
        }
        
        SQL_Statement += ");";        
        stmt.executeUpdate(SQL_Statement);
    }
    
    public static void main(String args[]) throws Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from emp");
        ResultSetMetaData rsm = rs.getMetaData();
        
        //Fetch Column_Names using ResultSetMetaData
        String col_name[][] = new String[10][10];
        String col_datatype[][] = new String[10][10];
        String col_values[] = new String[10];
        
        String col_values_multiple[][] = new String[10][10];
        int count = 1;
        while(count <= 5)
        {
            col_name[1][count] = rsm.getColumnName(count);
            col_datatype[1][count] = rsm.getColumnTypeName(count);
        }
        
        System.out.println("Enter your Choice\n=========================\n 1 = Insert a Single Record\n 2 = Insert Multiple Records\n 3 = Exit");
        Scanner sc = new Scanner(System.in);
        
        int i =1;
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1: 
            {
                System.out.println("Inserting Single Record");
                i++;
                while(col_name[1][i] != "")
                {
                    System.out.print("Enter the value for "+ col_name[1][i] +" datatype: "+ col_datatype[1][i] +": \n");
                    col_values[i] = sc.next(); 
                    i++;
                }
                
                Table_Insert(col_values, col_datatype[1]);
            }
            break;
            
            case 2:
            {
                
            }
            break;
            
            case 3:
            {
                
            }
            break;
            
        }
                

    }

}
