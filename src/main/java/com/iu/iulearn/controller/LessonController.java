package com.iu.iulearn.controller;

import com.iu.iulearn.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/all")
    public Object getAllLesson(){
        try {
            return new ResponseEntity<>(lessonService.getAllLessons(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Object getLessonById(@PathVariable int id){
        try {
            return new ResponseEntity<>(lessonService.getLessonById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public Object getLessonByCourseId(@RequestParam int courseId){
        try {
            return new ResponseEntity<>(lessonService.getLessonByCourseId(courseId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }



}
