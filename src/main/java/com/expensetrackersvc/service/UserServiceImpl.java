package com.expensetrackersvc.service;

import com.expensetrackersvc.exception.EntityType;
import com.expensetrackersvc.exception.ExceptionType;
import com.expensetrackersvc.exception.ExpenseTrackerException;
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

import static com.expensetrackersvc.exception.EntityType.USER;
import static com.expensetrackersvc.exception.ExceptionType.DUPLICATE_ENTITY;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public UserDto registration(UserDto userDto) {
        Role userRole;

        User user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            userRole = roleRepository.findByRole(UserRoles.PASSENGER);
            System.out.println("User Role : "+userRole);
            user = new User();

            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setMobileNumber(userDto.getMobileNumber());
            user.setRoles(new HashSet<>(Arrays.asList(userRole)));

            return UserMapper.toUserDto(userRepository.save(user));

        }
        throw exception(USER, DUPLICATE_ENTITY, userDto.getEmail());


    }
    /**
     * Returns a new RuntimeException
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return ExpenseTrackerException.throwException(entityType, exceptionType, args);
    }

}
