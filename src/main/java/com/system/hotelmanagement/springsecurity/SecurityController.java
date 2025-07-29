package com.system.hotelmanagement.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller()
public class SecurityController {

    @GetMapping("hotelmanagementsystem/customer/dashboard")
    public String clientHello() {
        return "customerdashboard";
    }

    @GetMapping("hotelmanagementsystem/admin/dashboard")
    public String adminHello() {
        return "admindashboard";
    }

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello Public!";
    }
}
