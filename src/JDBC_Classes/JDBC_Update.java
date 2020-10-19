package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Vishwa Prasad
 */
public class JDBC_Update 
{

    Statement stmt; 
    
    //function to update record for selected row
    public static void Table_Update(int emp_id) throws SQLException, ClassNotFoundException, Exception
    {
            int User_Ch;
            float UP_valf;
            String Col_name;
            String UP_val;
            String sta;
            
            
            Scanner s = new Scanner(System.in);

            Connection conn = JDBC_getconnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("Select * from Emp");
            ResultSetMetaData rsm=rs.getMetaData();
            for(int i=1;i<=5;i++){
                System.out.println(i+")"+rsm.getColumnName(i));
            }
            System.out.println("Choose the Employee information you want to change.(Enter numbers)");
            User_Ch=s.nextInt();
            Col_name=rsm.getColumnName(User_Ch);
            if(User_Ch==1){
                System.out.println("Employee id is a Primary Key, so it cannot be updated");
            }
            else if(User_Ch<=4){
                System.out.println("Enter the new "+Col_name);
                UP_val=s.next();
                sta="UPDATE emp SET "+Col_name+"='"+UP_val+"' WHERE Emp_ID="+emp_id;
                st.executeUpdate(sta);
                System.out.println("Employee Information Updated");
            }
            else{
                System.out.println("Enter the new "+Col_name);
                UP_valf=s.nextFloat();
                sta="UPDATE emp SET "+Col_name+"='"+UP_valf+"' WHERE Emp_ID="+emp_id;
                st.executeUpdate(sta);
                System.out.println("Employee Information Updated");
            }
            conn.close();
    }

}
