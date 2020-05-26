package com.iu.iulearn.service.impl;


import com.iu.iulearn.model.*;
import com.iu.iulearn.repository.CourseRepository;
import com.iu.iulearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        Course courseToUpdate = courseRepository.findById(course.getId()).get();
        if (courseToUpdate != null){
            courseToUpdate.setTitle(course.getTitle());
            courseRepository.save(course);
        }
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course getCourseByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Override
    public Course getCourseByLectureCount(int lectureCount) {
        return null;
    }

    @Override
    public Course getCourseByHourCount(int hourCount) {
        return null;
    }

    @Override
    public Course getCourseByView(int view) {
        return null;
    }

    @Override
    public Course getCourseByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public Course getCourseByDiscount(int discount) {
        return null;
    }

    @Override
    public Course getCourseByPromotionPrice(BigDecimal promotionPrice) {
        return null;
    }

    @Override
    public Course getCourseByContent(String content) {
        return null;
    }

    @Override
    public Course getCourseByLastUpdate(Timestamp lastUpdate) {
        return null;
    }

    @Override
    public Course getCourseByCategory(Category category) {
        return null;
    }

    @Override
    public Category getCourseCategory() {
        return null;
    }

    @Override
    public List<Video> getAllCourseVideo() {
        return null;
    }

    @Override
    public List<Material> getAllCourseMaterial() {
        return null;
    }

    @Override
    public Set<UserCourse> getAllUserCourse() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Page getCourseByPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return courseRepository.findAll(pageRequest);
    }
}
