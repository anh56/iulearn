package com.iu.iulearn.controller;

import com.iu.iulearn.dto.LoginDTO;
import com.iu.iulearn.model.User;
import com.iu.iulearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public Object addUser(@RequestBody User user){
        try {
            userService.addUser(user);
        } catch (Exception e){
            return new ResponseEntity<String>("Cannot create new user", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginDTO dto){
            User user = userService.getUserByEmail(dto.getEmail());
            if (user != null) {
                if (user.getPassword().equals(dto.getPassword())){
                    return new ResponseEntity<>("token", HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//
//    @PostMapping("/upload")
//    public void upload(String url){
//        userService.addMaterial(url);
//    }

