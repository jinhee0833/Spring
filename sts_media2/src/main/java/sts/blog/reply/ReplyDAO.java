package sts.blog.reply;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import sts.blog.mediagroup.MediagroupDTO;
import www.utility.DBClose;
import www.utility.DBOpen;
 
@Component
public class ReplyDAO {
  @Autowired
  private DBOpen dbopen = null;
  @Autowired
  private DBClose dbclose = null;
  
  public ReplyDAO(){
    System.out.println("ReplyDAO auto created...");
  }
 
  /**
   * 미디어 댓글 목록
   * 
   * @return
   */
  public ArrayList list(int mediano) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    ArrayList list = null;
 
    try {
      sql = new StringBuffer();
      sql.append(" SELECT replyno, content, passwd, rdate, mediano");
      sql.append(" FROM reply");
      sql.append(" WHERE mediano = ?");
      sql.append(" ORDER BY replyno DESC"); // DESC: 내림 차순 
 
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, mediano);
      rs = pstmt.executeQuery();  // SQL 실행
 
      list = new ArrayList();
      while (rs.next() == true) { // 첫 번째 레코드, 두번째 레코드
        ReplyDTO dto = new ReplyDTO();
        dto.setReplyno(rs.getInt("replyno"));
        dto.setContent(rs.getString("content"));
        dto.setPasswd(rs.getString("passwd"));
        dto.setRdate(rs.getString("rdate"));
        dto.setMediano(rs.getInt("mediano"));
 
        list.add(dto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt, rs);
    }
 
    return list;
  }
 
  /**
   * 미디어 댓글 등록
   * 
   * @return
   */
  public int create(ReplyDTO dto) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    ArrayList list = null;
 
    try {
      sql = new StringBuffer();
      sql.append(" INSERT INTO reply(replyno, content, passwd, rdate, mediano)");
      sql.append(" VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),");
      sql.append(" ?, ?, sysdate, ?)");
 
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, dto.getContent());
      pstmt.setString(2,  dto.getPasswd());
      pstmt.setInt(3, dto.getMediano());
      
      cnt = pstmt.executeUpdate();  // SQL 실행
 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt);
    }
 
    return cnt;
  }
  
  /**
   * 미디어 댓글 조회
   * 
   * @return
   */
  public ReplyDTO read(int replyno) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    ArrayList list = null;
    ReplyDTO dto = null;
    
    try {
      sql = new StringBuffer();
      sql.append(" SELECT replyno, content, passwd, rdate, mediano");
      sql.append(" FROM reply");
      sql.append(" WHERE replyno = ?");
 
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, replyno);
      rs = pstmt.executeQuery();  // SQL 실행
 
      rs.next();                  // 최초 첫번째 레코드로 이동
      dto = new ReplyDTO();
      dto.setReplyno(rs.getInt("replyno"));
      dto.setContent(rs.getString("content"));
      dto.setPasswd(rs.getString("passwd"));
      dto.setRdate(rs.getString("rdate"));
      dto.setMediano(rs.getInt("mediano"));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt, rs);
    }
 
    return dto;
  }  
  
  /**
   * 미디어 댓글 수정
   * 
   * @return
   */
  public int update(ReplyDTO dto) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    ArrayList list = null;
 
    try {
      sql = new StringBuffer();
      sql.append(" UPDATE reply");
      sql.append(" SET content=?");
      sql.append(" WHERE replyno=?");
 
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, dto.getContent());
      pstmt.setInt(2,  dto.getReplyno());
      
      cnt = pstmt.executeUpdate();  // SQL 실행
 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt);
    }
 
    return cnt;
  }
 
  /**
   * 미디어 댓글 패스워드 검사
   * 
   * @return 1: 일치, 0: 불일치
   */
  public int checkPasswd(ReplyDTO dto) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    ArrayList list = null;
    
    try {
      sql = new StringBuffer();
      sql.append(" SELECT COUNT(replyno) as cnt");
      sql.append(" FROM reply");
      sql.append(" WHERE replyno = ? AND passwd=?");
 
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, dto.getReplyno());
      pstmt.setString(2, dto.getPasswd());
      
      rs = pstmt.executeQuery();  // SQL 실행
      rs.next();                  // 최초 첫번째 레코드로 이동
      cnt = rs.getInt("cnt");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt, rs);
    }
 
    return cnt;
  }  
 
  /**
   * 미디어 댓글 삭제
   * 
   * @return
   */
  public int delete(ReplyDTO dto) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    ArrayList list = null;
 
    try {
      sql = new StringBuffer();
      sql.append(" DELETE FROM reply");
      sql.append(" WHERE replyno=?");
 
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1,  dto.getReplyno());
      
      cnt = pstmt.executeUpdate();  // SQL 실행
 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt);
    }
 
    return cnt;
  }
  
}