package com.expensetrackersvc.rest;

import com.expensetrackersvc.model.User;
import com.expensetrackersvc.repository.UserRepository;
import com.expensetrackersvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("allUsers")
    public ResponseEntity<List<User>> getUser() {
        List<User> userList = (List<User>) userRepository.findAll();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/search")
    public String searchByIDPassword(@Param("userEmail") String userEmail, @Param("userPassword") @NotBlank  @Size(min = 3) String userPassword){
//          List<User> userList= userRepository.findByUserEmailIdAndUserPassword(userEmail,userPassword);
          List<User> userList=userRepository.findByUserEmailAndUserPassword(userEmail,userPassword);
          if(userList.size()==0)  return "No record Found";

          return "Found the data ";
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws URISyntaxException {
       User result=userService.addUser(user);
        return ResponseEntity.created(new URI("/v1/user/" + result.getUserId() + result.getUserId())).body(result);

    }



}

