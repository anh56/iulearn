package com.iu.iulearn.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(name = "title", unique = true, nullable = false)
    private String title;

//    private String icon;

    @Getter
    @Setter
    @OneToMany(targetEntity = Course.class, mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    public Category(String title, List<Course> courses) {
        this.title = title;
        this.courses = courses;
    }
    public Category(String title) {
        this.title = title;
     }

    public Category() {
    }
}
