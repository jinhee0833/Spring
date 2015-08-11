package www.utility;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class DBClose {
  
  public DBClose(){
    System.out.println(">>>>> DBClose.java °´Ã¼ »ý¼º");  
  }//end
  
  public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
    try {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
      } catch (Exception e) {
      }
 
      try {
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      } catch (Exception e) {
      }
 
      try {
        if (con != null) {
          con.close();
          con = null;
        }
      } catch (Exception e) {
      }
 
    } catch (Exception e) {
    }
  }//end
 
  public void close(Connection con, PreparedStatement pstmt) {
    try {
      try {
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      } catch (Exception e) {
      }
 
      try {
        if (con != null) {
          con.close();
          con = null;
        }
      } catch (Exception e) {
      }
 
    } catch (Exception e) {
    }
  }//end
 
}//class end
 