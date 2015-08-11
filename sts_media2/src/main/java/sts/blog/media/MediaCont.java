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
    // poster ���� ���� ����
    // --------------------------------------------------------
    // ���۵� ������ �ڵ� ����Ǿ� ����.
    MultipartFile posterMF = dto.getPosterMF();

    // ������ ���۵� ���� ����
    String basePath = Utility.getRealPath(request, "/media/storage");
    // ������ ������ ����
    String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);

    dto.setPoster(poster); // ����� ���ϸ�
    // --------------------------------------------------------
    
    // --------------------------------------------------------
    // filename ���� ���� ����
    // --------------------------------------------------------
    // ���۵� ������ �ڵ� ����Ǿ� ����.
    MultipartFile filenameMF = dto.getFilenameMF();

    // ������ ���۵� ���� ����
    String filename = UploadSaveManager.saveFileSpring30(filenameMF, basePath);

    dto.setFilename(filename); // ���ϸ�
    dto.setFilesize(filenameMF.getSize()); // ���� ������
    // --------------------------------------------------------
    
    int mediagroupno = dto.getMediagroupno();
    
    int cnt = dao.create(dto);
    if (cnt > 0){
      // request.setAttribute("msg1", "�̵�� �׷��� ����߽��ϴ�.");
      // request.setAttribute("link1", "<input type='button' value='��� ���' onclick=\"location.href='./create.do';\">");
      
      mav.addObject("msg1", "�̵� ����߽��ϴ�.");
      mav.addObject("link1", "<input type='button' value='��� ���' onclick=\"location.href='./create.do?mediagroupno="+mediagroupno+"';\">");
      mav.addObject("link2", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
    }else{
      mav.addObject("msg1", "�̵�� ��Ͽ� �����߽��ϴ�.");
      mav.addObject("link1", "<input type='button' value='�ٽ� �õ�' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
      
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
      mav.addObject("msg1", "�̵� ���� �� �� �����ϴ�.");
      mav.addObject("link1", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\">");
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
    
    // ������ DBMS�� ��ϵ� ���� ������ �����ϱ����� ���ڵ� �о��
    MediaDTO oldDTO = dao.read(newDTO.getMediano());
 
    // --------------------------------------------------------
    // poster ���� ���� ����
    // --------------------------------------------------------
    // ���۵� ������ �ڵ� ����Ǿ� ����.
    MultipartFile posterMF = newDTO.getPosterMF();
 
    // System.out.println(">>>>> ������ �������� ���� ��� posterMF: " + posterMF);
    
    // ���� �����ϴ� ������ �ִٸ� ���� ���� ���� �� ������ ����
    if (posterMF.getSize() > 0){ 
      // ���� ���� ����
      String basePath = Utility.getRealPath(request, "/media/storage");
      Utility.deleteFile(basePath + "/" + oldDTO.getPoster());
 
      // ������ ���ο� ���� ����
      String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
 
      newDTO.setPoster(poster); // ���ο� ���ϸ� ����
    }else{
      newDTO.setPoster(oldDTO.getPoster()); // ���� ���� ����
    }
    // --------------------------------------------------------
    
    // --------------------------------------------------------
    // filename ���� ���� ����
    // --------------------------------------------------------
    // ���۵� ������ �ڵ� ����Ǿ� ����.
    MultipartFile filenameMF = newDTO.getFilenameMF();
 
    if (filenameMF.getSize() > 0){
      // ���� filename ����
      String basePath = Utility.getRealPath(request, "/media/storage");
      Utility.deleteFile(basePath + "/" + oldDTO.getFilename());
 
      // ���� ������ ���۵� ���� ����
      String filename = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
 
      newDTO.setFilename(filename); // ���ϸ�
      newDTO.setFilesize(filenameMF.getSize()); // ���� ������
    }else{
      newDTO.setFilename(oldDTO.getFilename());
      newDTO.setFilesize(oldDTO.getFilesize());
    }
    // --------------------------------------------------------
    
    int mediagroupno = newDTO.getMediagroupno();
    
    int cnt = dao.update(newDTO);
    if (cnt == 1){
      // request.setAttribute("msg1", "�̵�� �׷��� ����߽��ϴ�.");
      // request.setAttribute("link1", "<input type='button' value='��� ���' onclick=\"location.href='./create.do';\">");
      
      mav.addObject("msg1", "�̵�� ������ �����߽��ϴ�.");
      mav.addObject("link1", "<input type='button' value='��� ���' onclick=\"location.href='./create.do?mediagroupno="+mediagroupno+"';\">");
      mav.addObject("link2", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
    }else{
      mav.addObject("msg1", "�̵�� ���� ������ �����߽��ϴ�.");
      mav.addObject("link1", "<input type='button' value='�ٽ� �õ�' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
      
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
    
    // ���� ����
    // ������ DBMS�� ��ϵ� ���� ������ �����ϱ����� ���ڵ� �о��
    MediaDTO oldDTO = dao.read(dto.getMediano());
    
    // ���� poster ���� ����
    String basePath = Utility.getRealPath(request, "/media/storage");
    Utility.deleteFile(basePath + "/" + oldDTO.getPoster());
    
    // ���� filename ����
    Utility.deleteFile(basePath + "/" + oldDTO.getFilename());
    
    int cnt = dao.delete(dto.getMediano());
    
    int mediagroupno = dto.getMediagroupno();
    
    if (cnt == 1){
      mav.addObject("msg1", "�̵�� ������ �����߽��ϴ�.");
      mav.addObject("link2", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
    }else{
      mav.addObject("msg1", "�̵�� ���� ������ �����߽��ϴ�.");
      mav.addObject("link1", "<input type='button' value='�ٽ� �õ�' onclick='history.back()'>");
      mav.addObject("link2", "<input type='button' value='���' onclick=\"location.href='./list.do?mediagroupno="+mediagroupno+"';\">");
      
    }
    
    return mav;
  }
   
}
 


