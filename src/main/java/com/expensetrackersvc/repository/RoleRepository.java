package com.expensetrackersvc.repository;

import com.expensetrackersvc.model.Role;
import com.expensetrackersvc.model.UserRoles;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByRole(UserRoles role);
}
