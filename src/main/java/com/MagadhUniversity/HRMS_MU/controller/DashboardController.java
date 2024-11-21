//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.MagadhUniversity.HRMS_MU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    public DashboardController() {
    }

    @GetMapping({"/dashboard"})
    public String dashboard() {
        return "dashboard";
    }
}