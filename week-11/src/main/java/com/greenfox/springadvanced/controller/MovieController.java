package com.greenfox.springadvanced.controller;

import com.greenfox.springadvanced.model.AuthenticationRequest;
import com.greenfox.springadvanced.model.AuthenticationResponse;
import com.greenfox.springadvanced.model.GenreDto;
import com.greenfox.springadvanced.model.GenresListDto;
import com.greenfox.springadvanced.service.MovieService;
import com.greenfox.springadvanced.service.MyUserDetailService;
import com.greenfox.springadvanced.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieController {
    private AuthenticationManager authenticationManager;
    private MyUserDetailService userDetailService;
    private SecurityService securityService;
    private MovieService movieService;

    @Autowired
    public MovieController(AuthenticationManager authenticationManager, MyUserDetailService userDetailService,
                           SecurityService securityService, MovieService movieService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.securityService = securityService;
        this.movieService = movieService;
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

   @PostMapping("/login")
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

    @GetMapping("/genres")
    public ResponseEntity<GenresListDto> getGenres () throws IOException {
        return new ResponseEntity<>(movieService.callGenres(), HttpStatus.OK);
    }
}
