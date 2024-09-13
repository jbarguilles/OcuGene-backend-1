package com.ocugene.repository;

import com.ocugene.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public interface UserRepository extends JpaRepository<User, Integer> {
}
