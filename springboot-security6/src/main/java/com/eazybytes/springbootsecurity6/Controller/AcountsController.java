package com.eazybytes.springbootsecurity6.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcountsController {

    @GetMapping("/account")
    public String accountdetails(){
        return "Hello From Accounts!!!";
    }
}
