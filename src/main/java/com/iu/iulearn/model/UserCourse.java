package com.iu.iulearn.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_courses")
public class UserCourse {
    @Id
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private int role;

    public UserCourse(User user, Course course, int role) {
        this.user = user;
        this.course = course;
        this.role = role;
    }

    public UserCourse() {
    }
}
