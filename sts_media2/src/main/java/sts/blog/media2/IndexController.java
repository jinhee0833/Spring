package sts.blog.media2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

// http://localhost:9090/media2/index.do
@Controller
@RequestMapping("/index.do")
public class IndexController {

  public IndexController() {
    super();
    System.out.println("IndexController 객체 생성됨");
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView execute() {
    // 반환값이 되는 ModelAndView 인스턴스를 생성
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/index"); // tiles definition name
    modelAndView.addObject("msg", "Home start page 입니다.");

    return modelAndView;
  }
}
