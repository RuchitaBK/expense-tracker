package com.expensetrackersvc.controller.api;

import com.expensetrackersvc.controller.request.UserSignupRequest;
import com.expensetrackersvc.model.User;
import com.expensetrackersvc.repository.UserRepository;
import com.expensetrackersvc.service.UserServiceImpl;
import dto.response.Response;
import dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    /*
            This endpoint is used for registration of user (mainly customer )
     */
    @PostMapping("/signup")
    public Response signup(@Valid @RequestBody UserSignupRequest userSignupRequest) {

        return Response.ok().setPayload(registerUser(userSignupRequest, false));

    }

    private UserDto registerUser(UserSignupRequest userSignupRequest, boolean isAdmin) {
        UserDto userDto = new UserDto();
        userDto.setEmail(userSignupRequest.getEmail());
        userDto.setFirstName(userSignupRequest.getFirstName());
        userDto.setLastName(userSignupRequest.getLastName());
        userDto.setPassword(userSignupRequest.getPassword());
        userDto.setMobileNumber(userSignupRequest.getMobileNumber());
        userDto.setAdmin(isAdmin);

        return userService.registration(userDto);

    }

}

