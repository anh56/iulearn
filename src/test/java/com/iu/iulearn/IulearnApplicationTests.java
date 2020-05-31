package com.iu.iulearn;

import com.iu.iulearn.model.*;
import com.iu.iulearn.repository.CourseRepository;
import com.iu.iulearn.repository.UserCourseRepository;
import com.iu.iulearn.repository.UserRepository;
import com.iu.iulearn.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class IulearnApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Before
    public void init(){
        User user1 =  new User();
        user1.setId(1);
        user1.setPassword("12345678");
        user1.setEmail("test@test.com");
        System.out.println(user1.toString());

        userRepository.save(user1);

        Course course1 = new Course();
        course1.setId(1);
        course1.setCategory(new Category("test"));
        course1.setTitle("test course");
        course1.setImage("test link");
        course1.setLectures_count(12);
        course1.setHour_count(36);
        System.out.println(course1.toString());

        courseRepository.save(course1);
    }

    @Transactional
    @Test
    void contextLoads() {
       User user1 =  userRepository.findByEmail("test@test.com");
       Course course1 = courseRepository.findByTitle("test course");

        UserCourse userCourse1 = new UserCourse();
        userCourse1.setId(new UserCourseId(user1,course1));

        userCourseRepository.save(userCourse1);

        System.out.println(userCourse1.toString());


    }

}
