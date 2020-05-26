package com.iu.iulearn.controller;


import com.iu.iulearn.model.Lesson;
import com.iu.iulearn.service.LessonService;
import com.iu.iulearn.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private LessonService lessonService;
//
//    @GetMapping("/course")
//    public Object getMaterialByCourseId(int id){
//        try {
//            List<Lesson> lessons =  lessonService.getLessonByCourseId(id);
//            for (int index: lessons
//                 ) {
//
//            }
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/all")
    public Object getAllMaterial(){
        try {
            return new ResponseEntity<>(materialService.getAllMaterials(), HttpStatus.OK);
        } catch (Exception e){
    return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/{id}")
    public Object getMaterialById(@PathVariable int id){
        try {
            return new ResponseEntity<>(materialService.getMaterialById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public Object getMaterialByLessonId(@RequestParam int lessonId){
        try {
            return new ResponseEntity<>(materialService.getMaterialByLessonId(lessonId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }


}
