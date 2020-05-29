package com.iu.iulearn.controller;


import com.iu.iulearn.dto.CourseEnrollmentDTO;
import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.User;
import com.iu.iulearn.service.CourseService;
import com.iu.iulearn.service.UserCourseService;
import com.iu.iulearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enroll")
public class EnrollController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserCourseService userCourseService;

    @PostMapping("/enroll")
    public Object enrollUserToCourse(@RequestBody CourseEnrollmentDTO courseEnrollmentDTO){
        try {
            // get user info from security context
            Object principal =
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            //cast to userDetails
            UserDetails userDetails = (UserDetails) principal;

            String email = userDetails.getUsername();
            User user = userService.getUserByEmail(email);

            //TODO: implementation of user-course enrollment
            List<Course> courseList = new ArrayList<>();
            for (int i : courseEnrollmentDTO.getCourseListId()
                 ) {
                Course course = courseService.getCourseById(i);
                courseList.add(course);

            }




            return new ResponseEntity<>("Course Registration success", HttpStatus.OK);


        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
