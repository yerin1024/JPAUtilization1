package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("hello")
    public String hello(Model model) { //model에 데이터를 실어줌
        model.addAttribute("data", "hello!!!");
        return "hello"; //화면이름 (스프링부트의 타임리프가 resources:templates/ +뷰이름+ .html로 파일을 찾아서 매핑해줌)
    }
}
