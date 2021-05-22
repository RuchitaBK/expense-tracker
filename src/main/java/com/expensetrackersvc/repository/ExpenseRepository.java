package com.expensetrackersvc.repository;

import com.expensetrackersvc.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
