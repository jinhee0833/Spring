package sts.blog.media;
 
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 

import sts.blog.mediagroup.MediagroupDAO;
import www.utility.UploadSaveManager;
import www.utility.Utility;

@Controller
public class MediaCont {
  @Autowired
  MediaDAO dao = null;
  
  @Autowired
  MediagroupDAO mediagroupDAO = null;
  
  // http://localhost:9090/media2/media/list.do
  @RequestMapping(value="/media/list.do", method=RequestMethod.GET)
  public ModelAndView list(int mediagroupno, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/list"); // /media/list.jsp
    mav.addObject("root", request.getContextPath());
    
    ArrayList list = dao.list(mediagroupno);
    Iterator iter = list.iterator();
    
    while(iter.hasNext()){
      MediaDTO dto = (MediaDTO)iter.next();
      long filesize = dto.getFilesize();
      
      dto.setFilesizeUnit(Utility.getUnit(filesize));

    }
    
    mav.addObject("list", list);
    mav.addObject("title", mediagroupDAO.read(mediagroupno).getTitle());
    mav.addObject("mediagroupno", mediagroupno);
    
    return mav;
  }
 
  @RequestMapping(value="/media/create.do", method=RequestMethod.GET)
  public ModelAndView createForm(MediaDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/createForm");   // /media/createForm.jsp 
    
    mav.addObject("mediagroupno", dto.getMediagroupno());
    // request.setAttribute("mediagroupno", dto.getMediagroupno());
    return mav;
  }
  
  @RequestMapping(value="/media/create.do", method=RequestMethod.POST)
  public ModelAndView createProc(MediaDTO dto, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/msgView");   // /mediagroup/msgView.jsp 
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    // --------------------------------------------------------
    // poster 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile posterMF = dto.getPosterMF();

    // 서버에 전송된 파일 저장
    String basePath = Utility.getRealPath(request, "/media/storage");
    // 서버의 폴더에 저장
    String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);

    dto.setPoster(poster); // 저장된 파일명
    // --------------------------------------------------------
    
    // --------------------------------------------------------
    // filename 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile filenameMF = dto.getFilenameMF();

    // 서버에 전송된 파일 저장
    String filename = UploadSaveManager.saveFileSpring30(filenameMF, basePath);

    dto.setFilename(filename); // 파일명
    dto.setFilesize(filenameMF.getSize()); // 파일 사이즈
    // --------------------------------------------------------
    
    int mediagroupno = dto.getMediagroupno();
    
    int cnt = dao.create(dto);
    if (cnt > 0){
      // request.setAttribute("msg1", "미디어 그룹을 등록했습니다.");
      // request.setAttribute("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do';\">");
      
      mav.addObject("msg1", "미디어를 등록했습니다.");
      mav.addObject("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do?mediagroupno="+mediagroupno+"';\">");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
    }else{
      mav.addObject("msg1", "미디어 등록에 실패했습니다.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
      
    }
    
    return mav;
  }

  @RequestMapping(value="/media/read.do", method=RequestMethod.GET)
  public ModelAndView read(int mediano){
    ModelAndView mav = new ModelAndView();
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    MediaDTO dto = dao.read(mediano);
    mav.addObject("dto", dto);
    
    String filename = dto.getFilename();
    filename = filename.toUpperCase();
    
    if (filename.endsWith(".MP3")){
      mav.setViewName("/media/readMP3");
      
    }else if (filename.endsWith(".MP4")){
      mav.setViewName("/media/readMP4");
    
    }else{
      mav.setViewName("/media/msgView");
      mav.addObject("msg1", "미디어를 실행 할 수 없습니다.");
      mav.addObject("link1", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\">");
    }
    
    return mav;
  }
  
  @RequestMapping(value="/media/update.do", method=RequestMethod.GET)
  public ModelAndView updateForm(int mediano){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/updateForm");
    
    MediaDTO dto = dao.read(mediano);
    mav.addObject("dto", dto);
    
    return mav;
  }
  
  @RequestMapping(value="/media/update.do", method=RequestMethod.POST)
  public ModelAndView updateProc(MediaDTO newDTO, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/msgView");   // /media/msgView.jsp 
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    // 기존에 DBMS에 등록된 파일 정보를 추출하기위해 레코드 읽어옴
    MediaDTO oldDTO = dao.read(newDTO.getMediano());
 
    // --------------------------------------------------------
    // poster 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile posterMF = newDTO.getPosterMF();
 
    // System.out.println(">>>>> 파일을 선택하지 않은 경우 posterMF: " + posterMF);
    
    // 새로 전송하는 파일이 있다면 기존 파일 삭제 후 새파일 전송
    if (posterMF.getSize() > 0){ 
      // 기존 파일 삭제
      String basePath = Utility.getRealPath(request, "/media/storage");
      Utility.deleteFile(basePath + "/" + oldDTO.getPoster());
 
      // 서버에 새로운 파일 저장
      String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
 
      newDTO.setPoster(poster); // 새로운 파일명 지정
    }else{
      newDTO.setPoster(oldDTO.getPoster()); // 기존 파일 재사용
    }
    // --------------------------------------------------------
    
    // --------------------------------------------------------
    // filename 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile filenameMF = newDTO.getFilenameMF();
 
    if (filenameMF.getSize() > 0){
      // 기존 filename 삭제
      String basePath = Utility.getRealPath(request, "/media/storage");
      Utility.deleteFile(basePath + "/" + oldDTO.getFilename());
 
      // 새로 서버에 전송된 파일 저장
      String filename = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
 
      newDTO.setFilename(filename); // 파일명
      newDTO.setFilesize(filenameMF.getSize()); // 파일 사이즈
    }else{
      newDTO.setFilename(oldDTO.getFilename());
      newDTO.setFilesize(oldDTO.getFilesize());
    }
    // --------------------------------------------------------
    
    int mediagroupno = newDTO.getMediagroupno();
    
    int cnt = dao.update(newDTO);
    if (cnt == 1){
      // request.setAttribute("msg1", "미디어 그룹을 등록했습니다.");
      // request.setAttribute("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do';\">");
      
      mav.addObject("msg1", "미디어 정보를 수정했습니다.");
      mav.addObject("link1", "<input type='button' value='계속 등록' onclick=\"location.href='./create.do?mediagroupno="+mediagroupno+"';\">");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
    }else{
      mav.addObject("msg1", "미디어 정보 수정에 실패했습니다.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
      
    }
 
    return mav;
  }
  
  @RequestMapping(value="/media/delete.do", method=RequestMethod.GET)
  public ModelAndView deleteForm(MediaDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/deleteForm");

    mav.addObject("dto", dto);
    
    return mav;
  }
 
  @RequestMapping(value="/media/delete.do", method=RequestMethod.POST)
  public ModelAndView deleteProc(MediaDTO dto, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/msgView");
    mav.addObject("img", "<img src='./images/bu01.png'>");
    
    // 파일 삭제
    // 기존에 DBMS에 등록된 파일 정보를 추출하기위해 레코드 읽어옴
    MediaDTO oldDTO = dao.read(dto.getMediano());
    
    // 기존 poster 파일 삭제
    String basePath = Utility.getRealPath(request, "/media/storage");
    Utility.deleteFile(basePath + "/" + oldDTO.getPoster());
    
    // 기존 filename 삭제
    Utility.deleteFile(basePath + "/" + oldDTO.getFilename());
    
    int cnt = dao.delete(dto.getMediano());
    
    int mediagroupno = dto.getMediagroupno();
    
    if (cnt == 1){
      mav.addObject("msg1", "미디어 정보를 삭제했습니다.");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
    }else{
      mav.addObject("msg1", "미디어 정보 삭제에 실패했습니다.");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
      
    }
    
    return mav;
  }
   
}
 


