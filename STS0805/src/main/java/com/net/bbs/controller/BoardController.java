package com.net.bbs.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.net.bbs.dao.BoardDAO;
import com.net.bbs.dto.BoardDTO;

@Controller
public class BoardController { //POJO스타일
	
	@Autowired
	BoardDAO dao;
	
	@Autowired
	ServletContext application; //request, response, out, application
	
	@RequestMapping(value="/board_form.do")
	public String board_form(){
		String url="WEB-INF/views/board_write.jsp";
		return url;
	}//end
	
	@RequestMapping(value="/board_edit_form.do")
	public String board_form_edit(){			
		System.out.println("board_edt_form");
		String url="WEB-INF/views/board_edit.jsp";
		return url;
	}//end
	
	@RequestMapping(value="/board_insert.do")
	public ModelAndView board_insert(BoardDTO dto, 	@RequestParam("hobby") String[] hobby){
		ModelAndView mav = new ModelAndView();
			System.out.println("InsertController");
			StringBuffer sb = new StringBuffer();
			for(String h:hobby){sb.append(h+" ");}
			
			//multipartRequest 클래스 대신 MultipartFile클래스 사용
			
//			String path = application.getRealPath("upload");
			String path = "C:\\Mtest\\sts-bundle\\my7\\STS0805\\src\\main\\webapp\\upload\\";

			//getter 사용 안하고 getOriginalFilename() 사용
			String img=dto.getUpload_f().getOriginalFilename();
			File file = new File(path+img);
			
			try{
				dto.getUpload_f().transferTo(file);	
			}catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println("path="+path);
			
			
			
			dto.setHobby(sb.toString());
			dto.setImg_file_name(img);
			String url="board_list.do";
			mav.setViewName(url);
			dao.dbInsert(dto);
			
		return mav;
	}//end

	@RequestMapping(value="/board_list.do")
	public ModelAndView board_list(){
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> List = (List)dao.dbSelect();
		mav.addObject("bean",List);
		String url="WEB-INF/views/board_list.jsp";
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/board_detail.do")
	public ModelAndView board_detail(@RequestParam("idx") int idx){
		ModelAndView mav = new ModelAndView();
		System.out.println("detailController"+idx);
		BoardDTO dto = dao.dbDetail(idx);
		
		mav.addObject("bean",dto);
		
		
		String url="WEB-INF/views/board_detail.jsp";
		mav.setViewName(url);
		
		return mav;
	}
	
	@RequestMapping(value="/board_delete.do")
	public ModelAndView board_delete(@RequestParam("idx") int idx){
		ModelAndView mav = new ModelAndView();
		System.out.println("deleteController "+idx);
		dao.dbdelete(idx);
		String url="board_list.do";
		mav.setViewName(url);
		
		return mav;
	}
	
	@RequestMapping(value="/board_edit.do")
	public ModelAndView board_edit(BoardDTO dto,@RequestParam("hobby") String[] hobby){
		ModelAndView mav = new ModelAndView();
		System.out.println("board_edit");
		System.out.println("///////////"+dto.getName());
		
		
		StringBuffer sb = new StringBuffer();
		for(String h:hobby){sb.append(h+" ");}
		String path = "C:\\Mtest\\sts-bundle\\my7\\STS0805\\src\\main\\webapp\\upload\\";
		String img=dto.getUpload_f().getOriginalFilename();
		File file = new File(path+img);
		
		try{
			dto.getUpload_f().transferTo(file);	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("path="+path);
		
		dto.setHobby(sb.toString());
		dto.setImg_file_name(img);
		dao.dbupdate(dto);
		String url="board_list.do";
		mav.setViewName(url);
		
		return mav;
	}
}//class END
