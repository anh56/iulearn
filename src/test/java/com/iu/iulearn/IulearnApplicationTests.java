//package com.iu.iulearn;
//
//import com.iu.iulearn.model.Category;
//import com.iu.iulearn.model.Course;
//import com.iu.iulearn.model.User;
//import com.iu.iulearn.model.UserCourse;
//import com.iu.iulearn.repository.CourseRepository;
//import com.iu.iulearn.repository.UserRepository;
//import com.iu.iulearn.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class IulearnApplicationTests {
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Test
//    void contextLoads() {
//        User user1 =  new User();
//        user1.setPassword("12345678");
//        user1.setEmail("test@test.com");
//        System.out.println(userRepository.findByEmail("test@test.com"));
//        System.out.println(user1.toString());
//
//        Course course1 = new Course();
//        course1.setCategory(new Category("test"));
//        course1.setTitle("test course");
//        course1.setImage("test link");
//        course1.setLectures_count(12);
//        course1.setHour_count(36);
//        System.out.println(courseRepository.findByTitle("test course"));
//        System.out.println(course1.toString());
//
//        UserCourse userCourse1 = new UserCourse();
//        userCourse1.setUser(user1);
//        userCourse1.setCourse(course1);
//        System.out.println(userCourse1.toString());
//
//        user1.getUserCourses().add(userCourse1);
//
//        userRepository.save(user1);
//        courseRepository.save(course1);
//    }
//
//}
