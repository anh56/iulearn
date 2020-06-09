package com.iu.iulearn.repository;

import com.iu.iulearn.model.UserCourse;
import com.iu.iulearn.model.UserCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrolledCourseRepository extends JpaRepository<UserCourse, UserCourseId> {
    List<UserCourse> findAllById(UserCourseId userCourseId);
    List<UserCourse> findAllById_User_Email(String email);
    List<UserCourse> findAllById_User_Id(int id);

}
