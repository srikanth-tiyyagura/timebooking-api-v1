package com.honeybadgerworks.io.resumeportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumePortalController {

    @GetMapping("/")
    public String home() {
        return "hello Srikanth!";
    }

    @GetMapping("/edit")
    public String editView() {
        return "hello Srikanth! - you are in edit view";
    }
}
