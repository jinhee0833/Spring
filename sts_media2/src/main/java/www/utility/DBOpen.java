package www.utility;
 
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBOpen {
  public DBOpen(){
    System.out.println(">>>>> DBOpen.java 객체 생성");
  }//end
  
  public Connection getConnection(){
    Connection con = null;
    
    //------------------------------------------------------------
    // DBMS 접속 정보
    //------------------------------------------------------------
    try{
      String url = "jdbc:oracle:thin:@localhost:1521:XE";  // 자체 설치
      String id = "system";
      String pass = "oracle";
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      con = DriverManager.getConnection(url, id, pass); // DBMS 연결 설정
    }catch(Exception e){
      System.out.println(e.toString());
    }
    //------------------------------------------------------------
    return con;
    
  }//end
  
}//class end