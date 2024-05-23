package com.eazybytes.springbootsecurity6.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @GetMapping("/notice")
    public String noticedetails(){
        return "Hello Notice Board!!!";
    }
}
