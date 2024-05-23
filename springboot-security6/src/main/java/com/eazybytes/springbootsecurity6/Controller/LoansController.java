package com.eazybytes.springbootsecurity6.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/loans")
    public String loandetails(){
        return "Hello From Loans!!!";
    }
}
