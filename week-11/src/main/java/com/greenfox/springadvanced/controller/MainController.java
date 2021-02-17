package com.greenfox.springadvanced.controller;

import com.greenfox.springadvanced.model.AuthenticationRequest;
import com.greenfox.springadvanced.model.AuthenticationResponse;
import com.greenfox.springadvanced.service.MyUserDetailService;
import com.greenfox.springadvanced.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private AuthenticationManager authenticationManager;
    private MyUserDetailService userDetailService;
    private SecurityService securityService;

    @Autowired
    public MainController(AuthenticationManager authenticationManager, MyUserDetailService userDetailService,
                          SecurityService securityService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.securityService = securityService;
    }

    @GetMapping("/home")
    public String home() {
        return "<h1>Hello World!<h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Hello User!<h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Hello Admin!<h1>";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = securityService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
