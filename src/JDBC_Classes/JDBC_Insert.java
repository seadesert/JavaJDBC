package JDBC_Classes;


import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Arun Sri Krishna
 */

public class JDBC_Insert 
{
    static int r_count;
    static int c_count;
    static int record_count;
    
    //function to insert single record to Table
    public static void Table_Insert(String[] col_values, String[] col_datatype) throws SQLException, Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();
        
        get_empid();
        String SQL_Statement = "insert into emp values("+ r_count + " ";
        
        int index = 2;
        while(index <= c_count)
        {
            if(col_datatype[index].equals("VARCHAR"))
            {
                SQL_Statement += ",'" + col_values[index] + "' ";
            }
            else if (col_datatype[index].equals("INTEGER"))
            {
                SQL_Statement += ", " + Integer.parseInt(col_values[index]) + " ";
            }
            else if (col_datatype[index].equals("FLOAT"))
            {
                SQL_Statement += ", " + Float.parseFloat(col_values[index]) + " ";                
            }
            else
            {
                SQL_Statement += ", " + col_values[index] + " ";                 
            }
            index++;
        }
        
        SQL_Statement += ");";        
        stmt.executeUpdate(SQL_Statement);
        System.out.print("\n* 1 Record(s) added sucessfully! *\n");
        conn.close();
    }
    //function to insert multiple records to Table
    public static void Table_Insert(String[][] col_values, String[] col_datatype) throws SQLException, Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();

        String SQL_Statement = "insert into emp values(?, ?, ?, ?, ?);";
        PreparedStatement preparedStmt = conn.prepareStatement(SQL_Statement);

        
        for(int i =1; i<=record_count; i++)
        {
            for(int k =1; k<=c_count; k++)
            {
                //primary key
                if(k == 1)
                {
                    get_empid();
                    preparedStmt.setInt(k, r_count);
                }
                
                else if(col_datatype[k].equals("VARCHAR"))
                {
                    preparedStmt.setString (k, col_values[i][k]);
                }
                else if(col_datatype[k].equals("FLOAT"))
                {
                    preparedStmt.setFloat  (k, Float.parseFloat(col_values[i][k]));                  
                }
                else if(col_datatype[k].equals("INTEGER"))
                {
                    preparedStmt.setFloat  (k, Float.parseFloat(col_values[i][k]));
                }
            }
            preparedStmt.execute();
        }
        
        System.out.print("\n* "+ record_count +" Record(s) added sucessfully! *\n");
        conn.close();
    }
    

    public static void get_empid() throws Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from emp");
        ResultSetMetaData rsm = rs.getMetaData();

        rs.last();
        r_count = rs.getRow() + 1;
        conn.close();
    }
    
    
    public static void main(String args[]) throws Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from emp");
        ResultSetMetaData rsm = rs.getMetaData();

        get_empid();
        c_count = rsm.getColumnCount();
        

        String col_name[] = new String[10];
        String col_datatype[] = new String[10];
        String col_values[] = new String[10];
        String col_values_multiple[][] = new String[10][10];
        
        
        int index = 1;
        //Fetch Column_Names using ResultSetMetaData
        while(index <= c_count)
        {
            col_name[index] = rsm.getColumnName(index);
            col_datatype[index] = rsm.getColumnTypeName(index);     
            index++;
        }
  
        
        
        System.out.print("Enter your Choice\n=========================\n 1 = Insert a Single Record\n 2 = Insert Multiple Records\n 3 = Exit\n\n> ");
        Scanner sc = new Scanner(System.in);
        
        int i;
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1: 
            {
                System.out.print("Inserting Single Record for emp_id:" + r_count + "\n\n");
                i = 2;
                while(i <= c_count)
                {
                    System.out.print("Enter the value for "+ col_name[i] +" datatype: "+ col_datatype[i] +": \n");
                    col_values[i] = sc.next(); 
                    i++;
                }
                
                Table_Insert(col_values, col_datatype);
            }
            break;
            
            case 2:
            {

                int row_index = 1;
                
                System.out.print("Enter number of Records to insert:\n");
                record_count = sc.nextInt();
                
                System.out.print("Inserting Multiple Records from emp_id:" + r_count + "\n");
                
                while(row_index <= record_count)
                {
                    System.out.println("\nCurrent Record - emp_id:" + (r_count + row_index-1) );
                    i = 2;
                    while(i <= c_count)
                    {
                        System.out.print("Enter the value for "+ col_name[i] +" datatype: "+ col_datatype[i] +": \n");
                        col_values_multiple[row_index][i] = sc.next(); 
                        i++;
                    }
                    
                   row_index++;
                }
                Table_Insert(col_values_multiple, col_datatype);
            }
            break;
            
            case 3:
            {
                
            }
            break;
            
        }
                

    }

}
