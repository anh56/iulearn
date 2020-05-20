package com.iu.iulearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

public class UserController {


    @Autowired
    private AuthenticationManager authenticationManager;

}
