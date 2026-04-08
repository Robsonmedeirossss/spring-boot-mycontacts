package com.dev.mycontacts.services;

import com.dev.mycontacts.dto.request.CreateContactDto;
import com.dev.mycontacts.entities.Category;
import com.dev.mycontacts.entities.Contact;
import com.dev.mycontacts.exceptions.CategoryNotFoundException;
import com.dev.mycontacts.exceptions.ContactNotFoundException;
import com.dev.mycontacts.repositories.CategoryRepository;
import com.dev.mycontacts.repositories.ContactRepository;
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
                () -> new CategoryNotFoundException("Categoria com id " + createContactDto.getCategoryId() + " não existe")
        );

        return this.contactRepository.save(new Contact(
                createContactDto.getName(),
                createContactDto.getEmail(),
                createContactDto.getPhone(),
                category
        ));
    }

    public List<Contact> findAll() {
        return this.contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return this.contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contato com id " + id + " não encontrado")
        );
    }

    public void deleteById(Long id) {
        this.contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contato com id " + id + " não encontrado")
        );

        this.contactRepository.deleteById(id);
    }

    public Contact updateById(Long id, Contact newContact) {
        int rowsAffected = this.contactRepository.update(
                id,
                newContact.getName(),
                newContact.getEmail(),
                newContact.getPhone(),
                newContact.getCategory()
        );

        if(rowsAffected <= 0 ) {
            throw new ContactNotFoundException("Contato com id " + id + " não encontrado");
        }

        return newContact;
    }
}
