package com.expensetrackersvc.controller.api;

import com.expensetrackersvc.model.Category;
import com.expensetrackersvc.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @Operation(summary = "create expense")
    @PostMapping("/addCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws URISyntaxException {
        Category categoryResult=categoryRepository.save(category);

        return ResponseEntity.created(new URI("v1/category/"+category.getCategoryId() )).body(categoryResult);
    }

    @Operation(summary = "get Category data")
    @GetMapping("/getAllCategory")
    public ResponseEntity<List<Category>> getCategory(){
        List<Category> categoryList=  categoryRepository.findAll();
        return ResponseEntity.ok(categoryList);
    }

}
