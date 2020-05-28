package com.iu.iulearn.dto;

import com.iu.iulearn.model.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CourseEnrollmentDTO {

    @Getter
    @Setter
    private List<Course> courseList;
}
