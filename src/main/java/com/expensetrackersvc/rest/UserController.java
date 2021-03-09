package com.expensetrackersvc.rest;

import com.expensetrackersvc.dao.UserDao;
import com.expensetrackersvc.model.User;
import com.expensetrackersvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserRepository userRepository;



    @GetMapping("getUser")
    public ResponseEntity<List<User>> getUser(){
        List<User> userList= (List<User>) userRepository.findAll();
        return ResponseEntity.ok(userList);
    }
@PostMapping("/addUser")
    public String addUser(@Valid @RequestBody User user)  {
     userRepository.save(user);
     return "data saved";
}


}


//           User user=new User();
//           user.setUserId(id);
//           user.setUserName(name);
//           user.setUserEmail(mail);
//           user.setUserPassword(password);