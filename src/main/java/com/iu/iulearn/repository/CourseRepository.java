package com.iu.iulearn.repository;

import com.iu.iulearn.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByTitle (String title);
    Course findByCategory (String category);
//    List<Course> findByTitleRegex(String regex);
}
