package net.hb.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.hb.dao.GuestDAO;
import net.hb.dto.GuestDTO;

@Controller
public class HomeController { //순수자바=old자바=POJO스타일
	
	@Autowired
	private GuestDAO dao; //<bean:bean class="net.hb.dao.GuestDAO" />
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("home(1,2)");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);
		String fd = sdf.format(date);
		model.addAttribute("serverTime", fd );
		String url="/WEB-INF/views/home.jsp";
		return url;
	}
	
	@RequestMapping(value="guest.do")
	public ModelAndView guestForm(){
		ModelAndView mav = new ModelAndView();
		String url="/WEB-INF/views/guest.jsp";
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="insert.do")
	public ModelAndView guestInsert(@RequestParam Map param){
		ModelAndView mav = new ModelAndView();
		System.out.println("insert");
		Set st = param.keySet();
		Iterator it = st.iterator();
		
		while(it.hasNext()==true){
			
			String data = (String)it.next();
			System.out.println(data + " = "+param.get(data));
		}
		
		dao.dbInsert(param);
		String url="/WEB-INF/views/guestList.jsp";
		mav.setViewName(url);
		return mav;
	}
	
	
	@RequestMapping(value="insert2.do")
	public ModelAndView guestInsert2(GuestDTO dto){
		ModelAndView mav = new ModelAndView();
		System.out.println("사번="+dto.getSabun());
		System.out.println("이름="+dto.getName());
		System.out.println("제목="+dto.getTitle());
		System.out.println("급여="+dto.getPay());
		
//		dao.dbInsert(dto);
		String url="/WEB-INF/views/guestList.jsp";
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/list.do")
	public ModelAndView guestList(Map map){		
		System.out.println("guestList");
		Map bean = dao.dbSelect(map);
		String url="/WEB-INF/views/guestList.jsp";
		ModelAndView mav = new ModelAndView(url,bean);
//		mav.addObject("bean",bean);
//		mav.setViewName(url);
		return mav;
	}
	
	
	@RequestMapping(value="/detail.do")
	public ModelAndView guestDetail(@RequestParam Map map){		
		System.out.println("guestDetail");
	 
		Map bean = dao.dbDetail(map);
		String url="/WEB-INF/views/guestDetail.jsp";
		ModelAndView mav = new ModelAndView(url,bean);
	
		return mav;
	}
}
