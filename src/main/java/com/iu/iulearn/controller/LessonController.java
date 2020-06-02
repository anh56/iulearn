package com.iu.iulearn.controller;

import com.iu.iulearn.model.Lesson;
import com.iu.iulearn.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lesson")
@CrossOrigin
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/all")
    public Object getAllLesson() {
        try {
            return new ResponseEntity<>(lessonService.getAllLessons(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Object getLessonById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(lessonService.getLessonById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public Object getLessonByCourseId(@RequestParam int courseId) {
        try {
            return new ResponseEntity<>(lessonService.getLessonByCourseId(courseId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public Object addLesson(@RequestBody Lesson lesson) {
        try {
            lessonService.addLesson(lesson);
            return new ResponseEntity<>("Lesson added", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Lesson add failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Object updateLesson(@PathVariable int id, @RequestBody Lesson lesson) {
        try {
            lesson.setId(id);
            lessonService.updateLesson(lesson);
            return new ResponseEntity<>("Updated lesson with id: " + id + " sucessful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Update lesson with id: " + id + "failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteLesson(@PathVariable int id){
        try {
            lessonService.deleteLesson(id);
            return new ResponseEntity<>("Deleted lesson with id: "+id, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Delete lesson with id: "+id+" failed with exception: "+e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }


}
