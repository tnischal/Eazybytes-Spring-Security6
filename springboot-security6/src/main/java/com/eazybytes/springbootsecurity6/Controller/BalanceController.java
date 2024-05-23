package com.eazybytes.springbootsecurity6.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/balace")
    public String balancedetails(){
        return "Wow! $1M !!!";
    }
}
