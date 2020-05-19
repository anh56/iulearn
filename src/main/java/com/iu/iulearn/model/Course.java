package com.iu.iulearn.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
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
    @Column(name = "image", nullable = false)
    private String image;

    @Getter
    @Setter
    @Column(name = "lectures_count", nullable = false)
    private int lectures_count;

    @Getter
    @Setter
    @Column(name = "hour_count", nullable = false)
    private int hour_count;

    @Getter
    @Setter
    @Column(columnDefinition = "integer default 0")
    private int view_count;

    @Getter
    @Setter
    @Column(columnDefinition = "decimal(10,0) default 0")
    private BigDecimal price;

    @Getter
    @Setter
    @Column(columnDefinition = "integer default 0")
    private int discount;

    @Getter
    @Setter
    @Column(columnDefinition = "decimal(10,0) default 0")
    private BigDecimal promotion_price;

    @Getter
    @Setter
    @Column(columnDefinition = "text default NULL")
    private String content;

    @Getter
    @Setter
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp last_update;

    @Getter
    @Setter
    @Column(name = "category_id", nullable = false)
    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    @Getter
    @Setter
    @OneToMany(targetEntity = Video.class, mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Video> videos = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(targetEntity = Material.class, mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Material> materials = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "courses")
    private Set<UserCourse> userCourses;

    public Course(String title, String image, int lectures_count, int hour_count, int view_count, BigDecimal price, int discount, BigDecimal promotion_price, String content, Timestamp last_update, Category category, List<Video> videos, List<Material> materials, Set<UserCourse> userCourses) {
        this.title = title;
        this.image = image;
        this.lectures_count = lectures_count;
        this.hour_count = hour_count;
        this.view_count = view_count;
        this.price = price;
        this.discount = discount;
        this.promotion_price = promotion_price;
        this.content = content;
        this.last_update = last_update;
        this.category = category;
        this.videos = videos;
        this.materials = materials;
        this.userCourses = userCourses;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }
}

