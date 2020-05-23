package com.iu.iulearn.service;

import com.iu.iulearn.model.Role;
import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByFullname(String fullname);
    User getUserByPhone(String phone);
    User getUserByAddress(String address);
    User getUserByRole(Role role);
    User getUserByWebsite(String website);
    Role getAllUserRole();
    Set<UserCourse> getAllUserCourse();
    List<User> getAllUsers();
}
