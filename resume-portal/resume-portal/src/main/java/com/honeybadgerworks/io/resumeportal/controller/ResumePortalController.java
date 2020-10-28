package com.honeybadgerworks.io.resumeportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ResumePortalController {

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        model.addAttribute("userId", userId);
        return "profile";
    }

}
