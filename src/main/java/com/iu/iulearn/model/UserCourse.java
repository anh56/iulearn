package com.iu.iulearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_courses")
public class UserCourse {
    @EmbeddedId
    @Getter
    @Setter
    private UserCourseId id;

    public UserCourse(UserCourseId id) {
        this.id = id;
    }

    public UserCourse() {
    }

    //
//    @Id
//    @Getter
//    @Setter
//    @ManyToOne(cascade = CascadeType.ALL)
//    //@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
//    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//    private User user;
//
//    @Id
//    @Getter
//    @Setter
//    @ManyToOne(cascade = CascadeType.ALL)
//    //@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
//    @JoinColumn(name = "course_id", nullable = false, updatable = false)
//    private Course course;
//
////    @Getter
////    @Setter
////    @ManyToOne
////    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
////    @JsonIgnore
////    private int role;
//
//    public UserCourse(User user, Course course) {
//        this.user = user;
//        this.course = course;
////        this.role = role;
//    }
//
//    public UserCourse() {
//    }



}
