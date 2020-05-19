package com.iu.iulearn.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @NotNull
    private String title;

    @Getter
    @Setter
    @NotNull
    private String image;

    @Getter
    @Setter
    @NotNull
    private int lectures_count;

    @Getter
    @Setter
    @NotNull
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
    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    @OneToMany(targetEntity = Video.class, mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Video> videos = new ArrayList<>();

    @OneToMany(targetEntity = Material.class, mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Material> materials = new ArrayList<>();

    public Course(String title, String image, int lectures_count, int hour_count, int view_count, BigDecimal price, int discount, BigDecimal promotion_price, String content, Timestamp last_update, Category category) {
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
    }

    public Course() {
    }
}

