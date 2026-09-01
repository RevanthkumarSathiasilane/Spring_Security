package com.example.SpringSecurity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "Hello World "+request.getSession().getId();
    }
    @GetMapping("/")
    public String home(){
        return "Home Page";
    }
    @GetMapping("/about")
    public String aboutUs(){
        return "Kunal Kushwaha";
    }
}
