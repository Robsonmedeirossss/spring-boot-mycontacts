package com.dev.mycontacts.controllers;

import com.dev.mycontacts.dto.request.CreateContactDto;
import com.dev.mycontacts.entities.Contact;
import com.dev.mycontacts.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> findAll() {
        return this.contactService.findAll();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable Long id) {
        return this.contactService.findById(id);
    }

    @PostMapping
    public Contact createContact(@Valid @RequestBody CreateContactDto createContactDto) {
        return this.contactService.save(createContactDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        this.contactService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
