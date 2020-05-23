package com.iu.iulearn.security;


import com.iu.iulearn.model.User;
import com.iu.iulearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // get user from db
        User user = userRepository.findByEmail(email);
        if (user== null) throw new UsernameNotFoundException("No user found with this email: "+ email);

        // join role table to get role
        String roleName = user.getRole().getName();
        List<GrantedAuthority> authorities = new ArrayList<>();
        // role name must start with ROLE_someName
        authorities.add(new SimpleGrantedAuthority(roleName));

        return new CustomUserDetail(email, user.getPassword(), authorities);
    }
}
