package com.iu.iulearn.service;

import com.iu.iulearn.model.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface CourseService {
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int id);
    Course getCourseById(int id);
    Course getCourseByTitle(String title);
    Course getCourseByLectureCount(int lectureCount);
    Course getCourseByHourCount(int hourCount);
    Course getCourseByView(int view);
    Course getCourseByPrice(BigDecimal price);
    Course getCourseByDiscount(int discount);
    Course getCourseByPromotionPrice(BigDecimal promotionPrice);
    Course getCourseByContent(String content);
    Course getCourseByLastUpdate(Timestamp lastUpdate);
    Course getCourseByCategory(Category category);
    Category getCourseCategory();
    List<Video> getAllCourseVideo();
    List<Material> getAllCourseMaterial();
    Set<UserCourse> getAllUserCourse();
    List<Course> getAllCourses();
}
