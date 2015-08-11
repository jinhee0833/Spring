package com.net.cgv.test;
 
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


 



@Controller
public class MediaCont {
 
	@RequestMapping(value = "/media.do", method = RequestMethod.GET)
	 public String home() {
		System.out.println("//////////////////////////////////////////////////////////");
		return "/media";
	}
   
	
}
 


