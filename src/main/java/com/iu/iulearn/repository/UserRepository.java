package com.iu.iulearn.repository;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findById(int id);
}
