//package com.iu.iulearn;
//
//import com.iu.iulearn.model.Course;
//import com.iu.iulearn.model.Lesson;
//import com.iu.iulearn.repository.LessonRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//public class GetLessonByCourseIdTest {
//
//    @Autowired
//    private LessonRepository lessonRepository ;
//
//    @Before
//    public void init(){
//        Lesson lesson = new Lesson();
//        lesson.setId(999);
//        Course course = new Course();
//        course.setId(99);
//        lesson.setCourse(course);
//    }
//
//
//    @Test
//    public void test(){
//        Assert.assertNotNull(lessonRepository.findByCourse_Id(99));
//        Assert.assertNotEquals(" ", lessonRepository.findByCourse_Id(99));
//
//        Assert.assertNotNull(lessonRepository.findLessonsByCourse_Id(999));
//        Assert.assertNotEquals(" ", lessonRepository.findLessonsByCourse_Id(999));
//
//    }
//
//}
