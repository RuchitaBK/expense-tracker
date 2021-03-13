package com.expensetrackersvc.service;

import com.expensetrackersvc.model.User;
import com.expensetrackersvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
      User result=  userRepository.save(user);
        return result;
    }
}
