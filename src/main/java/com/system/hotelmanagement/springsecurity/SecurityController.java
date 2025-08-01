package com.system.hotelmanagement.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
 