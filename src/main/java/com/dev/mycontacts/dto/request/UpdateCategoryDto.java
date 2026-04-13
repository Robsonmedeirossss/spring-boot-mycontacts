package com.dev.mycontacts.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateCategoryDto {
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String name;

    public UpdateCategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
