package com.iu.iulearn.repository;

        import com.iu.iulearn.model.Course;
        import com.iu.iulearn.model.UserCourse;
        import com.iu.iulearn.model.UserCourseId;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseId> {
        List<UserCourse> findAllById_User_Email(String email);
        List<UserCourse> findAllById_Course_Id(int id);


}
