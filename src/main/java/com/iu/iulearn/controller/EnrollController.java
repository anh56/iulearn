package com.iu.iulearn.controller;


import com.iu.iulearn.dto.CourseEnrollmentDTO;
import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.User;
import com.iu.iulearn.model.UserCourse;
import com.iu.iulearn.model.UserCourseId;
import com.iu.iulearn.service.CourseService;
import com.iu.iulearn.service.UserCourseService;
import com.iu.iulearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/enroll")
public class EnrollController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserCourseService userCourseService;

//    @PostMapping("/enroll")
//    public Object enrollUserToCourse(@RequestBody CourseEnrollmentDTO courseEnrollmentDTO){
//        try {
//            // get user info from security context
//            Object principal =
//                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//            //cast to userDetails
//            UserDetails userDetails = (UserDetails) principal;
//
//            String email = userDetails.getUsername();
//            User user = userService.getUserByEmail(email);
//
//            //
//            List<Course> courseList = new ArrayList<>();
//            for (int i : courseEnrollmentDTO.getCourseListId()
//                 ) {
//                Course course = courseService.getCourseById(i);
//                courseList.add(course);
//
//            }
//
//
//
//
//            return new ResponseEntity<>("Course Registration success", HttpStatus.OK);
//
//
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
    @PostMapping("/{course_id}")
    public Object enrollCourse(@PathVariable int course_id){

        try {
//             get user info from security context
            Object principal =
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            //cast to userDetails
            UserDetails userDetails = (UserDetails) principal;

            String email = userDetails.getUsername();

            User user = userService.getUserByEmail(email);

            // add course and user to userCourse
            Course course = courseService.getCourseById(course_id);
            UserCourse userCourse = new UserCourse();
            userCourse.setId(new UserCourseId(user, course));

            userCourseService.addUserCourse(userCourse);

            return new ResponseEntity<String>("Registration for course with id: " +course_id+" is successful", HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Registration for course with id: "+course_id+" failed with exception: " + e.getMessage()
                    ,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{course_id}")
    public Object withdrawCourse(@PathVariable int course_id){
        try {
            // get user from token
            Object principal =
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            //cast to userDetails
            UserDetails userDetails = (UserDetails) principal;

            String email = userDetails.getUsername();

            User user = userService.getUserByEmail(email);
            Course course = courseService.getCourseById(course_id);
            UserCourse userCourse = new UserCourse();
            userCourse.setId(new UserCourseId(user, course));

            userCourseService.deleteUserCourse(userCourse);
            return new ResponseEntity<String>("Withdraw from course with id: " +course_id+" is successful", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Withdraw for course with id: "+course_id+" failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/user/email")
    public Object getEnrolledCourseByUserEmail(@RequestParam String email){
        try{
            return new ResponseEntity<>(userCourseService.getUserCourseByUserEmail(email).toString(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Get enrolled course by user email failed with exception: "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/user/{id}")
    public Object getEnrolledCourseByUserId(@PathVariable int id){
        try {
            return new ResponseEntity<>(userCourseService.getUserCourseByUserId(id).toString(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Get all enrollled course of user with id: " + id+" failed with exception: "
            + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public Object getAllEnrolledCourseOfAllUser(){
        try {
            return new ResponseEntity<>(userCourseService.getAllUserCourse().toString(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Get all enrolled courses of all users failed with exception: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
