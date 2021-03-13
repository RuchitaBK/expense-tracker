package com.expensetrackersvc.repository;

import com.expensetrackersvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


//    @Query("select user from User u where u.userEmail = ?1 and u.userPassword =?2")
    public List<User> findByUserEmailAndUserPassword(String userEmail,String userPassword);

//    @Query(value = "select user from User user where user.useremail =:userEmail AND user.userpassword = :userPassword")
//    public List<User> findByUserEmailIdAndUserPassword(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword );


}
