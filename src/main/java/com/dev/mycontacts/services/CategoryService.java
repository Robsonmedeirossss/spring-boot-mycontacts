package com.dev.mycontacts.services;

import com.dev.mycontacts.dto.request.CreateCategoryDto;
import com.dev.mycontacts.dto.request.UpdateCategoryDto;
import com.dev.mycontacts.entities.Category;
import com.dev.mycontacts.exceptions.CategoryNotFoundException;
import com.dev.mycontacts.repositories.CategoryRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(CreateCategoryDto category) {
        return this.categoryRepository.save(category.toEntity());
    }

    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Cateogira com id " + id + " não encontrada"));
    }

    public List<Category> findAll(int page, int size) {

        return this.categoryRepository.findAll(
                PageRequest.of(page, size)).getContent();
    }

    public void deleteById(Long id) {
        this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Categoria com id " + id + " não encontrada"));

        this.categoryRepository.deleteById(id);
    }

    public Category updateById(Long id, UpdateCategoryDto updateCategoryDto) {

        Category category = this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Categoria com id " + id + " não encontrada"));

        category.setName(updateCategoryDto.getName());

        return this.categoryRepository.save(category);
    }

}
