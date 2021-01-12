package levunguyen.demo_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
    @GetMapping("/hello")
    public String helloWorld(){
        return "hello";
    }

}
