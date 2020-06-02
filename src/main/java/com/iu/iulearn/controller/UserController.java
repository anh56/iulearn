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
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.jws.Oneway;
import java.util.Date;
import java.util.List;


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

    @GetMapping("/all")
    public Object getAllUser(){
        try {
            List<User> users =  userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Get all users failed with exception: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/page")
    public Object getUserByPage(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size){
        try {
            return new ResponseEntity<>(userService.getUserByPage(page, size), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>("Get user by page failed with exception: "+ e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable int id){
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Get user by id " + id +"fail with exception:"+ e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Object updateUserById(@PathVariable int id, @RequestBody User user){
        try {
            user.setId(id);
            userService.updateUser(user);
            return  new ResponseEntity<>("Updated user with id: "+id, HttpStatus.OK);


        } catch (Exception e){
            return new ResponseEntity<>("Update user by id: "+id+ "failed with exception: "+ e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteUserById(@PathVariable int id){
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Deleted user by id: "+id, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Delete user by id:"+id+" failed with exception: "+e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }









}


