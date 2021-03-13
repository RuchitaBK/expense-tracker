package com.expensetrackersvc.repository;

import com.expensetrackersvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    Category findByCategoryName(String name);
}
