package com.iu.iulearn.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @Column(name = "title", nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(name = "url", nullable = false)
    private String url;

    @Getter
    @Setter
    @Column(name = "time_count", nullable = false)
    private int time_count;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Lesson lesson;

//    public Video(String title, String url, int time_count, Course course) {
//        this.title = title;
//        this.url = url;
//        this.time_count = time_count;
//        this.course = course;
//    }


    public Video(String title, String url, int time_count, Lesson lesson) {
        this.title = title;
        this.url = url;
        this.time_count = time_count;
        this.lesson = lesson;
    }

    public Video() {
    }
}
