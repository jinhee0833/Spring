package sts.blog.mediagroup;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

@Component
public class MediagroupDAO {
  @Autowired
  private SqlMapClientTemplate mybatis;
  
  public MediagroupDAO(){
    System.out.println(">>>>> MediagroupDAO auto created...");  
  }
  
  /**
   * �̵�� �׷� ���
   * @param dto
   * @return
   */
  public int create(MediagroupDTO dto){
    // PK ����, AutoBoxing, Unboxing
    int cnt = (Integer)mybatis.insert("mediagroup.insert", dto);
    
    return cnt;
  }
  
  /**
   * �̵�� �׷� ���
   */
  public ArrayList list() {
    ArrayList list = (ArrayList)mybatis.queryForList("mediagroup.list");
    
    return list;
  }
  
  /**
   * ��ȸ�մϴ�.
   * @param mediagroupno ��ȸ�� �ڷ� ��ȣ
   * @return
   */
  public MediagroupDTO read(int mediagroupno){
    return (MediagroupDTO)mybatis.queryForObject("mediagroup.read", mediagroupno);
  }

  /**
   * �̵�� �׷��� �����մϴ�.
   * @param dto
   * @return ����� ���ڵ� ����
   */
  public int update(MediagroupDTO dto){
    return mybatis.update("mediagroup.update", dto);
  }
  
  /**
   * �̵�� �׷� 1���� �����մϴ�.
   * @param mediagroupno
   * @return ������ ���ڵ� ����
   */
  public int delete(int mediagroupno){
    return mybatis.delete("mediagroup.delete", mediagroupno);
  }
   
}


