package com.iu.iulearn.service;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.Lesson;

import java.util.List;

public interface LessonService {
    void addLesson(Lesson lesson);
    void updateLesson(Lesson lesson);
    void deleteLesson(int id);
    Lesson getLessonById(int id);
    Lesson getLessonByTitle(String title);
    Lesson getLessonByContent(String content);
    Lesson getLessonByCourse(Course course);
    List<Lesson> getLessonByCourseId(int courseId);

    Course getAllLessonCourse();
    List<Lesson> getAllLessons();
}
