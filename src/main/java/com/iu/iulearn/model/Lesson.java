package com.iu.iulearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {
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
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Course course;

    @Getter
    @Setter
    @OneToMany(targetEntity = Video.class, mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Video> videos = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(targetEntity = Material.class, mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Material> materials = new ArrayList<>();

    public Lesson(String title, String material_url, String content, Course course, List<Video> videos, List<Material> materials) {
        this.title = title;
        this.material_url = material_url;
        this.content = content;
        this.course = course;
        this.videos = videos;
        this.materials = materials;
    }

    public Lesson() {
    }
}
