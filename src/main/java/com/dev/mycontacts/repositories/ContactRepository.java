package com.dev.mycontacts.repositories;

import com.dev.mycontacts.entities.Category;
import com.dev.mycontacts.entities.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.name = :name, c.email = :email, c.phone = :phone, c.category = :category WHERE c.id = :id")
    int update(@Param("id") Long id,
               @Param("name") String name,
               @Param("email") String email,
               @Param("phone") String phone,
               @Param("category")Category category);
}
