package com.iu.iulearn.controller;

import com.iu.iulearn.model.Role;
import com.iu.iulearn.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public Object getAllRole(){
        try {
            List<Role> roles = roleService.getAllRoles();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<String>("Get all role fail with exception: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public Object addRole(@RequestBody Role role){
        try {
            roleService.addRole(role);
            return new ResponseEntity<>("Role added with id: "+role.getId(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>("Add fail with exception: " + e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Object updateRole(@PathVariable int id, @RequestBody Role role){
        try {
            role.setId(id);
            roleService.updateRole(role);
            return new ResponseEntity<>("Role updated at id: "+id, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Update fail with exception: " +e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteRole(@PathVariable int id){
        try {
            roleService.deleteRole(id);
            return new ResponseEntity<>("Deleted role with id: "+ id, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Delete fail with exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
