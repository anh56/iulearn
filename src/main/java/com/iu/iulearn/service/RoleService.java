package com.iu.iulearn.service;

import com.iu.iulearn.model.Role;
import com.iu.iulearn.model.User;

import java.util.List;

public interface RoleService {
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(int id);
    Role getRoleById(int id);
    Role getRoleByName(String name);
    Role getRoleByDescription(String description);
    Role getRoleByUser(User user);
    List<User> getAllRoleUser();
    List<Role> getAllRoles();
}
