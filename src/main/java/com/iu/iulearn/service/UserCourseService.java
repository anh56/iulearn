package com.iu.iulearn.service;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;

import java.util.List;

public interface UserCourseService {
    void addUserCourse(UserCourse userCourse);
    void updateUserCourse(UserCourse userCourse);
    void deleteUserCourse(UserCourse userCourse);
    void deleteUserCourseByUser(User user);
    void deleteUserCourseByCourse(Course course);
    UserCourse getUserCourseByUser(User user);
    UserCourse getUserCourseByCourse(Course course);
    User getAllUserCourseUser();
    Course getAllUserCourseCourse();
    List<UserCourse> getAllUserCourse();

    List<UserCourse> getUserCourseByUserEmail(String email);

    List<UserCourse> getUserCourseByUserId(int id);
}
