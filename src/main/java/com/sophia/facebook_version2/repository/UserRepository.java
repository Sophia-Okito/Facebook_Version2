package com.sophia.facebook_version2.repository;

import com.sophia.facebook_version2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email, String password);
}

