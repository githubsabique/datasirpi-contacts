package com.datasirpi.contacts.service;

import com.datasirpi.contacts.data.repo.Contact;

import java.util.List;

/**
 * @author sabique
 */
public interface ContactService {

    List<Contact> listContacts();

    Contact saveContact(Contact contact);

    Contact deleteContact(Long id) throws Exception;
}
