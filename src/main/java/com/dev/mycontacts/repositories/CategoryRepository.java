package com.dev.mycontacts.repositories;

import com.dev.mycontacts.entities.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Category c SET c.name = :name WHERE c.id = :id")
    int update(@Param("id") Long id, @Param("name") String name);
}
