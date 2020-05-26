package com.iu.iulearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(name = "material_url", nullable = false)
    private String material_url;

    @Getter
    @Setter
    @Column(columnDefinition = "longtext default NULL")
    private String content;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Lesson lesson;

//    public Material(String title, String material_url, String content, Course course) {
//        this.title = title;
//        this.material_url = material_url;
//        this.content = content;
//        this.course = course;
//    }


    public Material(String title, String material_url, String content, Lesson lesson) {
        this.title = title;
        this.material_url = material_url;
        this.content = content;
        this.lesson = lesson;
    }

    public Material() {
    }
}
