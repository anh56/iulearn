package com.iu.iulearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Getter
    @Setter
    private String fullname;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(255) default NULL")
    private String avatar;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(255) default NULL")
    private String phone;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(255) default NULL")
    private String address;

    @Getter
    @Setter
//    @Column(name = "role_id", nullable = false)
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Role role;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(255) default NULL")
    private String website;

    @Getter
    @Setter
    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<UserCourse> userCourses;

    public User(String email, String password, String fullname, String avatar, String phone, String address, Role role, String website, Set<UserCourse> userCourses) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.website = website;
        this.userCourses = userCourses;
    }

    public User() {
    }
}
