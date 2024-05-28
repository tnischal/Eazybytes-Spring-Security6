package com.eazybytes.springbootsecurity6.config.CostumLoginCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerEntity customer){

        System.out.println(customer.getEmail());
        CustomerEntity savedCustomer;
        ResponseEntity response= null;
        try{
            customer.setPwd(passwordEncoder.encode(customer.getPwd()));
            savedCustomer = customerRepo.save(customer);
            if(savedCustomer.getId()>0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("User Registered");
            }

        }catch (Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception: "+ex);
        }

        return response;

    }
}
