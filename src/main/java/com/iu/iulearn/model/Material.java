package com.iu.iulearn.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "content", nullable = false)
    private String content;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    public Material(String title, String material_url, String content, Course course) {
        this.title = title;
        this.material_url = material_url;
        this.content = content;
        this.course = course;
    }

    public Material() {
    }
}
