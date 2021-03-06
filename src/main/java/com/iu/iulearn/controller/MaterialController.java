package com.iu.iulearn.controller;



import com.iu.iulearn.model.Material;
import com.iu.iulearn.service.LessonService;
import com.iu.iulearn.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
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

    @GetMapping("")
    public Object getMaterialByLessonId(@RequestParam int lessonId){
        try {
            return new ResponseEntity<>(materialService.getMaterialByLessonId(lessonId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/add")
    public Object addMaterial(@RequestBody Material material) {
        try {
            materialService.addMaterial(material);
            return new ResponseEntity<>("Material added", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Material add failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Object updateMaterial(@PathVariable int id, @RequestBody Material material) {
        try {
            material.setId(id);
            materialService.updateMaterial(material);
            return new ResponseEntity<>("Updated material with id: " + id + " successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Update material with id: " + id + "failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteMaterial(@PathVariable int id){
        try {
            materialService.deleteMaterial(id);
            return new ResponseEntity<>("Deleted material with id: "+id, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Delete material with id: "+id+" failed with exception: "+e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }


}
