package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;
import com.iu.iulearn.repository.EnrolledCourseRepository;
import com.iu.iulearn.repository.UserCourseRepository;
import com.iu.iulearn.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    private UserCourseRepository userCourseRepository;

    @Autowired
    private EnrolledCourseRepository enrolledCourseRepository;

    @Override
    public void addUserCourse(UserCourse userCourse) {
    userCourseRepository.save(userCourse);
    }

    @Override
    public void updateUserCourse(UserCourse userCourse) {

    }

    @Override
    public void deleteUserCourse(UserCourse userCourse) {
        userCourseRepository.delete(userCourse);
    }

    @Override
    public void deleteUserCourseByUser(User user) {

    }

    @Override
    public void deleteUserCourseByCourse(Course course) {

    }

    @Override
    public UserCourse getUserCourseByUser(User user) {
        return null;
    }

    @Override
    public UserCourse getUserCourseByCourse(Course course) {
        return null;
    }

    @Override
    public User getAllUserCourseUser() {
        return null;
    }

    @Override
    public Course getAllUserCourseCourse() {
        return null;
    }

    @Override
    public List<UserCourse> getAllUserCourse() {
        List<UserCourse> userCourses = enrolledCourseRepository.findAll();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userCourses.toString());
        System.out.println(userCourses.get(1).getId().getUser().getEmail().toString());
        System.out.println("==============================================");
        return userCourses;
    }

    @Override
    public List<UserCourse> getUserCourseByUserEmail(String email) {
        return  enrolledCourseRepository.findAllById_User_Email(email);
    }

    @Override
    public List<UserCourse> getUserCourseByUserId(int id) {
        return enrolledCourseRepository.findAllById_User_Id(id);
    }

}
