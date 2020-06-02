package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Role;
import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;
import com.iu.iulearn.repository.UserRepository;
import com.iu.iulearn.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addUser(User user) {
        // check for available email
        User userToAdd = userRepository.findByEmail(user.getEmail());
        if (userToAdd == null){
            // encrypt password before saving
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId());
        if (userToUpdate != null ){
            modelMapper.map(userToUpdate, user);
            userRepository.save(userToUpdate);
        }
    }

    @Override
    public void deleteUser(int id) {

userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
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
        return userRepository.findAll();
    }

    @Override
    public Page getUserByPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest);
    }
}
