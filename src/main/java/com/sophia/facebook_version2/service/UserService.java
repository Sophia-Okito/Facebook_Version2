package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.User;
import com.sophia.facebook_version2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

}
