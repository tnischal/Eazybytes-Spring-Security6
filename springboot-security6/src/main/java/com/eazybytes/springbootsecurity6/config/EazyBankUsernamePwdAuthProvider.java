package com.eazybytes.springbootsecurity6.config;

import com.eazybytes.springbootsecurity6.config.CostumLoginCreation.CustomerEntity;
import com.eazybytes.springbootsecurity6.config.CostumLoginCreation.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class EazyBankUsernamePwdAuthProvider implements AuthenticationProvider {

    @Autowired
    private  CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Optional<CustomerEntity> customerEntity = customerRepo.findByEmail(username);
        if(customerEntity.isPresent()){
            if(passwordEncoder.matches(pwd,customerEntity.get().getPwd())){
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customerEntity.get().getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            }
            else throw new BadCredentialsException("Username and Password does not match");
        }
        else throw new UsernameNotFoundException("Username Not found!");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
