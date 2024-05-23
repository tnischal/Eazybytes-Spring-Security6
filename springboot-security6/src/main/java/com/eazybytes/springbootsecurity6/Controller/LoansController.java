package com.eazybytes.springbootsecurity6.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/loan")
    public String loandetails(){
        return "Hello From Loans!!!";
    }
}
