package com.example.demo11.Web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuriteControler {
@GetMapping("/403")
    public  String NotAutonticated(){
    return "403";
}

}
