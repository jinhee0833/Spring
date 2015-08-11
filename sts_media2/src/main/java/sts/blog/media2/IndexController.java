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
    System.out.println("IndexController ��ü ������");
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView execute() {
    // ��ȯ���� �Ǵ� ModelAndView �ν��Ͻ��� ����
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/index"); // tiles definition name
    modelAndView.addObject("msg", "Home start page �Դϴ�.");

    return modelAndView;
  }
}
