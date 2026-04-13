package com.dev.mycontacts.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateContactDto {

    @Size(min = 1, message = "Nome do contato deve ter pelo menos 2 caracteres")
    @NotEmpty(message = "Nome do contato não pode ser nul")
    private String name;

    @Email(message = "Campo email deve ser um email válido")
    @NotEmpty(message = "Email do contato não pode ser nul")
    private String email;

    @Size(min = 10, message = "Telfone deve ter pelo menos 10 caracteres")
    @NotEmpty(message = "Telefone do contato não pode ser nul")
    private String phone;

    private Long categoryId;

    public CreateContactDto(String name, String email, String phone, Long categoryId) {
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

}
