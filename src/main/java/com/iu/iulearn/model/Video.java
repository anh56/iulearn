package com.iu.iulearn.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "videos")
public class Video {
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
    private String url;

    @Getter
    @Setter
    @NotNull
    private int time_count;

    @Getter
    @ManyToOne()
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    public Video(@NotNull String title, @NotNull String url, @NotNull int time_count, Course course) {
        this.title = title;
        this.url = url;
        this.time_count = time_count;
        this.course = course;
    }

    public Video() {
    }
}
