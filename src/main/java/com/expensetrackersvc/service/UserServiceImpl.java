package com.expensetrackersvc.service;

import com.expensetrackersvc.model.User;
import com.expensetrackersvc.repository.UserRepository;
import dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDto registration(UserDto userDto) {

    User user=userRepository.findByEmail(userDto.getEmail());
    if(user==null){
        user=new User();
                user.setEmail(userDto.getEmail());
                user.setFirstName(userDto.getFirstName());
                user.setLastName(userDto.getLastName());
                user.setMobileNumber(userDto.getMobileNumber());
    }
    }
}
