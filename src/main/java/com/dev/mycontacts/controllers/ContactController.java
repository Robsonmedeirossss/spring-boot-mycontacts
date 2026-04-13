package com.dev.mycontacts.controllers;

import com.dev.mycontacts.dto.request.CreateContactDto;
import com.dev.mycontacts.dto.request.UpdateContactDto;
import com.dev.mycontacts.entities.Contact;
import com.dev.mycontacts.services.ContactService;
import jakarta.validation.Valid;
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
    public List<Contact> findAll(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "2") Integer size) {

        return this.contactService.findAll(page, size);
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

    @PatchMapping("/{id}")
    public Contact updateById(@Valid @PathVariable Long id, UpdateContactDto updateContactDto) {
        return this.contactService.updateById(id, updateContactDto);
    }

}
