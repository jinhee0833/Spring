package sts.blog.media;
 
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;
 
@Component
public class MediaDAO {
  @Autowired
  private SqlMapClientTemplate mybatis;
  
  public MediaDAO(){
    System.out.println(">>>>> MediaDAO auto created...");  
  }
  
  public ArrayList list(int mediagroupno){
    ArrayList list = (ArrayList)mybatis.queryForList("media.list", mediagroupno);
    
    return list;
  }

  /**
   * �̵�� ���
   * 
   * @return
   */
  public int create(MediaDTO dto) {
    // PK ����, AutoBoxing, Unboxing
    int cnt = (Integer)mybatis.insert("media.insert", dto);
    
    return cnt;
  }
  
  /**
   * ��ȸ
   * 
   * @return
   */
  public MediaDTO read(int mediano) {
    return (MediaDTO)mybatis.queryForObject("media.read", mediano);
  }
  
  /**
   * �̵�� ����
   * 
   * @return
   */
  public int update(MediaDTO dto) {
    return mybatis.update("media.update", dto);
  }
  
  /**
   * �̵�� ����
   * 
   * @return
   */
  public int delete(int mediano) {
    return mybatis.delete("media.delete", mediano);
  }
   
}
 


