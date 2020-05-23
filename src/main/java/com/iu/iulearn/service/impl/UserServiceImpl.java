package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Role;
import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;
import com.iu.iulearn.repository.UserRepository;
import com.iu.iulearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) == null){
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByFullname(String fullname) {
        return null;
    }

    @Override
    public User getUserByPhone(String phone) {
        return null;
    }

    @Override
    public User getUserByAddress(String address) {
        return null;
    }

    @Override
    public User getUserByRole(Role role) {
        return null;
    }

    @Override
    public User getUserByWebsite(String website) {
        return null;
    }

    @Override
    public Role getAllUserRole() {
        return null;
    }

    @Override
    public Set<UserCourse> getAllUserCourse() {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
