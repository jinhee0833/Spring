package sts.blog.reply;
 
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import sts.blog.media.MediaDAO;
import sts.blog.media.MediaDTO;
import sts.blog.mediagroup.MediagroupDTO;
import www.utility.Utility;
 
@Controller
public class ReplyCont {
  @Autowired
  private ReplyDAO dao;
  @Autowired
  private MediaDAO mediaDAO; 
  
  public ReplyCont(){
    System.out.println("ReplyCont auto created...");
  }
  
  @RequestMapping(value="/reply/list.do", method=RequestMethod.GET)
  public ModelAndView list(ReplyDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/reply/list");   // /reply/list.jsp 
    
    mav.addObject("list", dao.list(dto.getMediano()));
    
    // mediano를 이용하여 댓글 작성 대상인 파일의 정보 추출
    MediaDTO mediaDTO = mediaDAO.read(dto.getMediano());
    mav.addObject("mediaDTO", mediaDTO);
    
    return mav;
  }  
 
  @RequestMapping(value="/reply/create.do", method=RequestMethod.POST)
  public void createProc(ReplyDTO dto, HttpServletResponse response){
    try{
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      int cnt = dao.create(dto);
      
      if (cnt == 1){
        out.write("댓글을 등록했습니다.");
 
      }else{
        out.write("댓글 등록에 실패했습니다. 다시 시도해주세요");
      }
      
    }catch(Exception e){
      System.out.println(e.toString());
    }
  }
  
  /**
   * jQuery 호출, 조회 폼
   * @param dto
   * @param response
   */
  @RequestMapping(value="/reply/read.do", method=RequestMethod.GET)
  public void updateForm(ReplyDTO dto, HttpServletResponse response){
    try{
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      dto = dao.read(dto.getReplyno());
      out.write(dto.getContent());
      
    }catch(Exception e){
      System.out.println(e.toString());
    }
 
  }  
  
  @RequestMapping(value="/reply/update.do", method=RequestMethod.POST)
  public void updateProc(ReplyDTO dto, HttpServletResponse response){
    try{
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      int cnt = dao.checkPasswd(dto);
      
      if (cnt == 0){
        out.write("FAIL/패스워드가 일치하지 않습니다.\n\n패스워드를 다시 입력해주세요."); 
      }else{
        cnt = dao.update(dto);
 
        if (cnt == 1){
          out.write("SUCCESS/댓글을 수정했습니다.");
 
        }else{
          out.write("FAIL/댓글 수정에 실패했습니다. 다시 시도해주세요");
        }
      }
    }catch(Exception e){
      System.out.println(e.toString());
    }
  }
  
  @RequestMapping(value="/reply/delete.do", method=RequestMethod.POST)
  public void deleteProc(ReplyDTO dto, HttpServletResponse response){
    try{
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      int cnt = dao.checkPasswd(dto);
      
      if (cnt == 0){
        out.write("FAIL/패스워드가 일치하지 않습니다.\n\n패스워드를 다시 입력해주세요."); 
      }else{
        cnt = dao.delete(dto);
 
        if (cnt == 1){
          out.write("SUCCESS/댓글을 삭제했습니다.");
 
        }else{
          out.write("FAIL/댓글 삭제에 실패했습니다. 다시 시도해주세요");
        }
      }
    }catch(Exception e){
      System.out.println(e.toString());
    }
  }  
}
 