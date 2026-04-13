package com.dev.mycontacts.controllers;

import com.dev.mycontacts.dto.request.CreateCategoryDto;
import com.dev.mycontacts.dto.request.UpdateCategoryDto;
import com.dev.mycontacts.entities.Category;
import com.dev.mycontacts.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        return this.categoryService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }

    @PostMapping
    public Category createCategory(@Valid @RequestBody CreateCategoryDto categoryDto) {
        return this.categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.categoryService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public Category updateById(@Valid @PathVariable Long id, @RequestBody UpdateCategoryDto updateCategoryDto) {
        return this.categoryService.updateById(id, updateCategoryDto);
    }

}
