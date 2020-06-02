package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Role;
import com.iu.iulearn.model.User;
import com.iu.iulearn.repository.RoleRepository;
import com.iu.iulearn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        Role entity = roleRepository.findById(role.getId()).get();
        if(entity != null) {
            entity.setName(role.getName());
            entity.setDescription(role.getDescription());
            roleRepository.save(entity);
        }
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);

    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role getRoleByName(String name) {
        return null;
    }

    @Override
    public Role getRoleByDescription(String description) {
        return null;
    }

    @Override
    public Role getRoleByUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllRoleUser() {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
