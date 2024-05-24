package com.eazybytes.springbootsecurity6.config.CostumLoginCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(CustomerEntity customer){

        CustomerEntity savedCustomer = null;
        ResponseEntity response =null;
        try{
            String hashPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
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
