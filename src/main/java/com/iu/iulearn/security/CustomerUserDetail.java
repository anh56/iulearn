package com.iu.iulearn.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomerUserDetail extends User {
    private String email;
    private String fullName;
    private String avatar;
    private String phone;
    private String address;


    public CustomerUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


}
