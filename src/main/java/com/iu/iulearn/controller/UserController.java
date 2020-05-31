package com.iu.iulearn.controller;

import com.iu.iulearn.dto.LoginDTO;
import com.iu.iulearn.model.User;
import com.iu.iulearn.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS})
public class UserController {

//    @Value("${JWT_SECRET_KEY }")
    private final static String JWT_SECRET_KEY = "!*&!1nt3ll3ctu@LUn1vErs3S3cr$tKey!*&!";

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public Object addUser(@RequestBody User user) {
        if (userService.getUserByEmail(user.getEmail()) == null) {
            userService.addUser(user);
            return new ResponseEntity<>("User added", HttpStatus.CREATED);
        }
            else return new ResponseEntity<String>("User with this email existed", HttpStatus.BAD_REQUEST);
        }

    @PostMapping("login")
    public Object login(@RequestBody LoginDTO loginDTO) {

        try {
            // authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            // build token
            User userToDeliver = userService.getUserByEmail(loginDTO.getEmail());
            Date dateNow = new Date();
            String token = Jwts.builder()
                    .setSubject(loginDTO.getEmail()) // sub as email
                    .claim("fullName", userToDeliver.getFullName())
                    .claim("phone", userToDeliver.getPhone())
                    .claim("address", userToDeliver.getAddress())
                    .claim("avatar", userToDeliver.getAvatar())
                    .claim("website", userToDeliver.getWebsite())
                    .setIssuedAt(dateNow)            // created date
                    .setExpiration(new Date(dateNow.getTime() + 864000000L)) // expiry date = 10 days after created
                    .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                    .compact();
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (BadCredentialsException b) {
            return new ResponseEntity<>("Wrong username or password", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("User not available", HttpStatus.BAD_REQUEST);
        }
    }
}


