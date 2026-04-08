package com.dev.mycontacts.dto.request;

import com.dev.mycontacts.entities.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateCategoryDto {

    @NotEmpty(message = "Nome da categoria não pode ser vazio")
    @Size(min = 2, message = "Nome da categoria deve ter pelo menos 2 caractere")
    private String name;

    public CreateCategoryDto() {}

    public CreateCategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toEntity() {
        return new Category(this.name);
    }
}
