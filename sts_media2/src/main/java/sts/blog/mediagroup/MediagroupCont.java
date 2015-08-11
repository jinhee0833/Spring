package sts.blog.mediagroup;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MediagroupCont {
  @Autowired
  private MediagroupDAO dao;
  
  public MediagroupCont(){
    System.out.println(">>>>> MediagroupCont auto created...");
  }
  
  // http://localhost:9090/media2/mediagroup/create.do
  @RequestMapping(value="/mediagroup/create.do", method=RequestMethod.GET)
  public ModelAndView createForm(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/createForm"); // /mediagroup/createForm.jsp
  
    return mav;
  }
 
  // http://localhost:9090/media2/mediagroup/create.do
  @RequestMapping(value="/mediagroup/create.do", method=RequestMethod.POST)
  public ModelAndView createProc(MediagroupDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/msgView"); // /mediagroup/msgView.jsp
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    int cnt = dao.create(dto);
    if (cnt > 0){
      // request.setAttribute("msg1", "미디어 그룹을 등록했습니다.");
      // request.setAttribute("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do';\">");
      
      mav.addObject("msg1", "미디어 그룹을 등록했습니다.");
      mav.addObject("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do';\">");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do';\">");
    }else{
      mav.addObject("msg1", "미디어 그룹 등록에 실패했습니다.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do';\">");
      
    }
    
    return mav;     
  }
  
  // http://localhost:9090/media2/mediagroup/list.do
  @RequestMapping(value="/mediagroup/list.do", method=RequestMethod.GET)
  public ModelAndView list(HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/list"); // /mediagroup/list.jsp
    mav.addObject("root", request.getContextPath());
    mav.addObject("list", dao.list());
        
    return mav;
  }
  
  // http://localhost:9090/media2/mediagroup/update.do
  @RequestMapping(value="/mediagroup/update.do", method=RequestMethod.GET)
  public ModelAndView updateForm(int mediagroupno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/updateForm"); // /mediagroup/updateForm.jsp
    mav.addObject("dto", dao.read(mediagroupno));
        
    return mav;

  }
  
  // http://localhost:9090/media2/mediagroup/update.do
  @RequestMapping(value="/mediagroup/update.do", method=RequestMethod.POST)
  public ModelAndView updateProc(MediagroupDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/msgView"); // /mediagroup/msgView.jsp
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    int cnt = dao.update(dto);
    if (cnt == 1){
      // request.setAttribute("msg1", "미디어 그룹을 등록했습니다.");
      // request.setAttribute("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do';\">");
      
      mav.addObject("msg1", "미디어 그룹을 수정했습니다.");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do';\">");
    }else{
      mav.addObject("msg1", "미디어 그룹 수정에 실패했습니다.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do';\">");
      
    }
    
    return mav;   
  } 
  
  // http://localhost:9090/media2/mediagroup/delete.do
  @RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.GET)
  public ModelAndView deleteForm(int mediagroupno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/deleteForm"); // /mediagroup/deleteForm.jsp
    mav.addObject("mediagroupno", mediagroupno);
    // request.setAttribute("mediagroupno", mediagroupno);
        
    return mav;
  }
  
  // http://localhost:9090/media2/mediagroup/delete.do
  @RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.POST)
  public ModelAndView deleteProc(int mediagroupno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/msgView"); // /mediagroup/msgView.jsp
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    int cnt = dao.delete(mediagroupno);
    if (cnt == 1){
      mav.addObject("msg1", "미디어 그룹을 삭제했습니다.");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do';\">");
    }else{
      mav.addObject("msg1", "미디어 그룹 삭제에 실패했습니다.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do';\">");
      
    }
    
    return mav;   
  }  
  
}
 




