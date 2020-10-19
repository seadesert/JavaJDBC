package JDBC_Classes;

import static JDBC_Classes.JDBC_Connection.JDBC_getconnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nagashree MK
 */
public class JDBC_Drop {

    
    public static void main(String[] args) {
        Connection conn = null;
   Statement stmt = null;
   try{

      conn = JDBC_getconnection();
      System.out.println("Connected database successfully...");
       System.out.println("Deleting database...");
      stmt = conn.createStatement();
      
      String sql = "DROP DATABASE emp";
      stmt.executeUpdate(sql);
      System.out.println("Database deleted successfully...");
   }catch(SQLException se){
       se.printStackTrace();
   }catch(Exception e){
       e.printStackTrace();
   }finally{
 
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
    }
    
}
