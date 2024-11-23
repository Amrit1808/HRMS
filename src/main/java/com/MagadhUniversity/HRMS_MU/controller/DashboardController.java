package com.MagadhUniversity.HRMS_MU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Refers to dashboard.html in templates
    }
}
