package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.Lesson;
import com.iu.iulearn.repository.LessonRepository;
import com.iu.iulearn.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void updateLesson(Lesson lesson) {
        Lesson lessonToUpdate = lessonRepository.findById(lesson.getId()).get();
        if (lessonToUpdate != null){
            lessonToUpdate.setTitle(lesson.getTitle());
            lessonRepository.save(lesson);
        }
    }

    @Override
    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public Lesson getLessonById(int id) {
        return lessonRepository.findById(id).get();
    }

    @Override
    public Lesson getLessonByTitle(String title) {
        return null;
    }


    @Override
    public Lesson getLessonByContent(String content) {
        return null;
    }

    @Override
    public Lesson getLessonByCourse(Course course) {
        return null;
    }

    @Override
    public List<Lesson> getLessonByCourseId(int courseId) {
        return lessonRepository.findByCourseId(courseId) ;
    }

    @Override
    public Course getAllLessonCourse() {
        return null;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }
}
