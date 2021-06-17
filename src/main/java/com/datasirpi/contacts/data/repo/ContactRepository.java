package com.datasirpi.contacts.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author sabique
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from Contact c where c.deleted = 'F'")
    List<Contact> getAllContacts();
}
