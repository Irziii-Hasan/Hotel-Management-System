package com.system.hotelmanagement.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller()
public class SecurityController {

    @GetMapping("hotelmanagementsystem/dashboard")
    public String adminHello() {
        return "dashboard";
    }

    @GetMapping("/client/hello")
    public String clientHello() {
        return "Hello Client!";
    }

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello Public!";
    }
}
