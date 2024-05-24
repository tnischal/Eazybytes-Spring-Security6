package com.eazybytes.springbootsecurity6.config.CostumLoginCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        Optional<CustomerEntity> customerEntity= customerRepo.findByEmail(username);
        boolean a = customerEntity.isPresent();
        if(!customerEntity.isPresent()){
            throw new UsernameNotFoundException("User details not found for the user:"+ username);
        } else {
            CustomerEntity customer = customerEntity.get();
            userName = customer.getEmail();
            password = customer.getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getRole()));
        }
        return new User(userName,password,authorities);

    }
}
