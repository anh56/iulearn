package com.iu.iulearn.controller;


import com.iu.iulearn.model.Course;
import com.iu.iulearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public Object getAllCourse(){
        try {
            return new ResponseEntity<List<Course>>(courseService.getAllCourses(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }


    // iu/api/course/3
    @GetMapping("/{id}")
    public Object getCourseById(@PathVariable int id){
        try {
            return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/page")
    public Object getProductList(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size){
        try {
            return new ResponseEntity<Page>(courseService.getCourseByPage(page, size), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public Object add(@RequestBody Course course){
        try {
            courseService.addCourse(course);
            return new ResponseEntity<>("Added course" , HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Add course failed with exception: "+e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Object updateCourseById(@PathVariable int id, @RequestBody Course course){
        try {
            course.setId(id);
            courseService.updateCourse(course);
            return new ResponseEntity<>("Updated course with id: "+id, HttpStatus.OK);


        } catch (Exception e){
            return new ResponseEntity<>("Update course by id: "+id+ "failed with exception: "+ e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteCourseById(@PathVariable int id){
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>("Deleted course by id: "+id, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Delete course by id:"+id+" failed with exception: "+e.getMessage()
                    , HttpStatus.BAD_REQUEST);
        }
    }
}
