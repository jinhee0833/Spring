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
   * 미디어 그룹 등록
   * @param dto
   * @return
   */
  public int create(MediagroupDTO dto){
    // PK 리턴, AutoBoxing, Unboxing
    int cnt = (Integer)mybatis.insert("mediagroup.insert", dto);
    
    return cnt;
  }
  
  /**
   * 미디어 그룹 목록
   */
  public ArrayList list() {
    ArrayList list = (ArrayList)mybatis.queryForList("mediagroup.list");
    
    return list;
  }
  
  /**
   * 조회합니다.
   * @param mediagroupno 조회할 자료 번호
   * @return
   */
  public MediagroupDTO read(int mediagroupno){
    return (MediagroupDTO)mybatis.queryForObject("mediagroup.read", mediagroupno);
  }

  /**
   * 미디어 그룹을 변경합니다.
   * @param dto
   * @return 변경된 레코드 갯수
   */
  public int update(MediagroupDTO dto){
    return mybatis.update("mediagroup.update", dto);
  }
  
  /**
   * 미디어 그룹 1건을 삭제합니다.
   * @param mediagroupno
   * @return 삭제된 레코드 갯수
   */
  public int delete(int mediagroupno){
    return mybatis.delete("mediagroup.delete", mediagroupno);
  }
   
}


