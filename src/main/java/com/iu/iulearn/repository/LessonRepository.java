package com.iu.iulearn.repository;

import com.iu.iulearn.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByCourseId(int courseID);
}
