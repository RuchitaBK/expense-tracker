package com.expensetrackersvc.service;

import com.expensetrackersvc.model.Role;
import com.expensetrackersvc.model.User;
import com.expensetrackersvc.model.UserRoles;
import com.expensetrackersvc.repository.RoleRepository;
import com.expensetrackersvc.repository.UserRepository;
import dto.mapper.UserMapper;
import dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public UserDto registration(UserDto userDto) {
        Role userRole;
        userRole = roleRepository.findByRole(UserRoles.PASSENGER);
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            user = new User();

            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setMobileNumber(userDto.getMobileNumber());
            user.setRoles(new HashSet<>(Arrays.asList(userRole)));



        }
        return UserMapper.toUserDto(userRepository.save(user));
//        throw exception(USER, DUPLICATE_ENTITY, userDto.getEmail());
    }
}
