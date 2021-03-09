package com.expensetrackersvc.repository;

import com.expensetrackersvc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
