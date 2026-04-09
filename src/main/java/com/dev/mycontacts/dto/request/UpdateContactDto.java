package com.dev.mycontacts.dto.request;

import com.dev.mycontacts.entities.Category;
import com.dev.mycontacts.entities.Contact;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UpdateContactDto {
    @Size(min = 2, max = 255, message = "Campo nome deve ter entre 2 e 255 caracteres")
    private String name;

    @Email(message = "Campo email deve ser valido")
    private String email;

    @Size(min = 10, message = "Campo telefone deve ter no mínimo 10 caracteres")
    private String phone;

    private Long categoryId;

    public UpdateContactDto() {}

    public UpdateContactDto(String name, String email, String phone, Long categoryId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public static void merge(Contact contact, UpdateContactDto updateContactDto, Category category) {
        if(updateContactDto.getName() != null) {
            contact.setName(updateContactDto.getName());
        }

        if(updateContactDto.getEmail() != null) {
            contact.setEmail(updateContactDto.getEmail());
        }

        if(updateContactDto.getPhone() != null) {
            contact.setPhone(updateContactDto.getPhone());
        }

        if(updateContactDto.getCategoryId() != null) {
            contact.setCategory(category);
        }
    }
}
