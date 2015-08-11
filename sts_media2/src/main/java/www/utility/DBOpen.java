package www.utility;
 
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBOpen {
  public DBOpen(){
    System.out.println(">>>>> DBOpen.java ��ü ����");
  }//end
  
  public Connection getConnection(){
    Connection con = null;
    
    //------------------------------------------------------------
    // DBMS ���� ����
    //------------------------------------------------------------
    try{
      String url = "jdbc:oracle:thin:@localhost:1521:XE";  // ��ü ��ġ
      String id = "system";
      String pass = "oracle";
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      con = DriverManager.getConnection(url, id, pass); // DBMS ���� ����
    }catch(Exception e){
      System.out.println(e.toString());
    }
    //------------------------------------------------------------
    return con;
    
  }//end
  
}//class end