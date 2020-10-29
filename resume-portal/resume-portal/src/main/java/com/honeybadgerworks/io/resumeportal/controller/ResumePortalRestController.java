package com.honeybadgerworks.io.resumeportal.controller;

import com.honeybadgerworks.io.resumeportal.domain.UserProfile;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class ResumePortalRestController {

    @GetMapping("/")
    public String home() {
        return "index";
    }



}
