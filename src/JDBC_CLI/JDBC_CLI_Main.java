package JDBC_CLI;

import java.util.Scanner;
import JDBC_Classes.*;
import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Arun Sri Krishna (MY.SC.U3BCA18054)
 */
public class JDBC_CLI_Main {

    /**
     * @param args the command line arguments
     */
    
    static int max_emp_id = 0;
    
    public static void get_maxempid() throws Exception
    {
        Connection conn = JDBC_getconnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from emp");
        ResultSetMetaData rsm = rs.getMetaData();

        rs.last();
        max_emp_id = rs.getRow() + 1;
        conn.close();
    }
    
    
    
    public static void main(String[] args) throws Exception, SQLException{
       
        int ch = -1;
        
        while(ch != 7)
        {
        System.out.print("Enter your Choice\n================================\n 1 = Create Table for employees\n 2 = Insert Records to table\n 3 = Display Table\n 4 = Update Records in table\n 5 = Delete Records from table\n 6 = Drop table\n 7 = Exit Application\n\n> ");
        Scanner sc = new Scanner(System.in);

         
         ch = sc.nextInt();

            switch(ch)
            {
                case 1: JDBC_Create.Table_Create();
                break;
                
                case 2: JDBC_Insert.CLI_Insert();
                break;
                
                case 3: JDBC_Display.Table_Display();
                break;
                
                case 4: 
                {    
                    System.out.print("\nEnter the emp_id of the Record to be UPDATED:\n > ");
                    int emp_id = sc.nextInt();
                    get_maxempid();
                    if(emp_id < max_emp_id)
                    {
                        JDBC_Update.Table_Update(emp_id);
                    }
                    else
                    {
                        System.out.println("\nError: Invalid emp_id ");
                    }
                }
                break;
                
                case 5: 
                {
                    System.out.print("\nEnter the emp_id(s) of the Record to be DELETED: (0 to DELETE ALL RECORDS AND ENTER -1 to STOP)\n");
                    int emp_id[] = new int[10];
                    int i=0;
                    Boolean multiple = null;
                    get_maxempid();
                    emp_id[i] = sc.nextInt();
                    i++;

                    
                    while(emp_id[i] != -1)
                    {
                        emp_id[i] = sc.nextInt();
                        
                        //delete all records
                        if(emp_id[0] == 0)
                        {
                            JDBC_Delete.Table_Delete();
                            break;
                        }
                            
                        //delete single record
                        if(emp_id[1] < max_emp_id && emp_id[1] == -1)
                        {
                            JDBC_Delete.Table_Delete(emp_id[0]);
                            break;
                        }
                        
                        //delete multiple records
                        else if(emp_id[i] == -1)
                        {
                            if(emp_id[i] < max_emp_id)
                            {
                               multiple = true;
                            }
                            else
                            {
                                multiple = false;
                                break;
                            }
                        }
                        
                        i++;
                    }
                    if(multiple != null)
                    {
                        if(multiple == true)
                        {
                            JDBC_Delete.Table_Delete(emp_id);
                        }
                        else if(multiple == false)
                        {
                            System.out.println("\nError: Invalid emp_id \n");
                            break;
                        }
                        
                    }
                }
                break;
                
                case 6: 
                {
                    System.out.print("\n* Are you sure you want to Drop the table? *\n 1 = Confirm\n 2 = Cancel\n > ");
                    int confirm = sc.nextInt();
                    
                    if(confirm == 1)
                    {
                        JDBC_Drop.Table_Drop();
                    }
                }
                break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n* Error: Invalid Choice  *");

            }
        
        }    
    }
    
}
