package com.iu.iulearn.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany(targetEntity = User.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Role(String name, String description, List<User> users) {
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }
}
