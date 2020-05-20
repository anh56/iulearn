package com.iu.iulearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_courses")
public class UserCourse implements Serializable {
    @Id
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private User user;

    @Id
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Course course;

//    @Getter
//    @Setter
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
//    @JsonIgnore
//    private int role;

    public UserCourse(User user, Course course) {
        this.user = user;
        this.course = course;
//        this.role = role;
    }

    public UserCourse() {
    }
}
