package com.expensetrackersvc.controller.api;

import com.expensetrackersvc.model.Expense;
import com.expensetrackersvc.repository.ExpenseRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/expense")
public class ExpenseController {

    @Autowired
    ExpenseRepository expenseRepository;


    @Operation(summary = "Add Expense to user")
    @PostMapping("/addExpense")
    public ResponseEntity<Expense> createExpense(@RequestBody @Valid  Expense expense) throws URISyntaxException {
        Expense expenseResult=expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/v1/expense/" + expenseResult.getExpenseId())).body(expenseResult);
    }
    @Operation(summary = "get all Expense Data")
    @GetMapping("/allExpense")
  public ResponseEntity<List<Expense>> getExepense(){
       List<Expense>expenseList= expenseRepository.findAll();
       return ResponseEntity.ok(expenseList);
    }
}
