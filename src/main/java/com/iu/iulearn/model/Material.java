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
    @NotNull
    private String title;

    @Getter
    @Setter
    @NotNull
    private String material_url;

    @Getter
    @Setter
    @NotNull
    private String content;

    @Getter
    @ManyToOne()
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    public Material(@NotNull String title, @NotNull String material_url, @NotNull String content, Course course) {
        this.title = title;
        this.material_url = material_url;
        this.content = content;
        this.course = course;
    }

    public Material() {
    }
}
