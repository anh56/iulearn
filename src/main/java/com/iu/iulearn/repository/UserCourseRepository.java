package com.iu.iulearn.repository;

import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {
}
