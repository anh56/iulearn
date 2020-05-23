package com.iu.iulearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(name = "name", unique = true)
    private String name;

    @Getter
    @Setter
    @Column(columnDefinition = "varchar(255) default NULL")
    private String description;

    @Getter
    @Setter
    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany( mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;

    public Role(String name, String description, List<User> users) {
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Role() {
    }
}
