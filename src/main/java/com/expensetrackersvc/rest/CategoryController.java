package com.expensetrackersvc.rest;

import com.expensetrackersvc.model.Category;
import com.expensetrackersvc.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    CategoryRepository categoryRepository;



}
