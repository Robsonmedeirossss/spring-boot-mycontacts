package com.dev.mycontacts.services;

import com.dev.mycontacts.dto.request.CreateContactDto;
import com.dev.mycontacts.dto.request.UpdateContactDto;
import com.dev.mycontacts.entities.Category;
import com.dev.mycontacts.entities.Contact;
import com.dev.mycontacts.exceptions.CategoryNotFoundException;
import com.dev.mycontacts.exceptions.ContactNotFoundException;
import com.dev.mycontacts.repositories.CategoryRepository;
import com.dev.mycontacts.repositories.ContactRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private CategoryRepository categoryRepository;

    public ContactService(ContactRepository contactRepository, CategoryRepository categoryRepository) {

        this.contactRepository = contactRepository;
        this.categoryRepository = categoryRepository;
    }

    public Contact save(CreateContactDto createContactDto) {

        Category category = this.categoryRepository.findById(createContactDto.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException(
                        "Categoria com id " + createContactDto.getCategoryId() + " não existe"));

        return this.contactRepository.save(new Contact(
                createContactDto.getName(),
                createContactDto.getEmail(),
                createContactDto.getPhone(),
                category));
    }

    public List<Contact> findAll(int page, int size) {
        return this.contactRepository.findAll(
                PageRequest.of(page, size)).getContent();
    }

    public Contact findById(Long id) {
        return this.contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contato com id " + id + " não encontrado"));
    }

    public void deleteById(Long id) {
        this.contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contato com id " + id + " não encontrado"));

        this.contactRepository.deleteById(id);
    }

    public Contact updateById(Long id, UpdateContactDto updateContactDto) {

        Contact contact = this.contactRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Contato com id " + id + " não encontrado"));

        Category category = this.categoryRepository.findById(contact.getCategory().getId())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria com id " + id + " não encontrada"));

        UpdateContactDto.merge(contact, updateContactDto, category);

        return this.contactRepository.save(contact);

    }
}
