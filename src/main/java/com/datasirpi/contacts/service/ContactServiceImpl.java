package com.datasirpi.contacts.service;

import com.datasirpi.contacts.data.repo.Contact;
import com.datasirpi.contacts.data.repo.ContactRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author sabique
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listContacts() {
        LOG.info("List all contacts from database {}", this.getClass().getSimpleName());
        return contactRepository.getAllContacts();
    }

    public Contact saveContact(Contact contact) {
        LOG.info("Saving contact to database {}", this.getClass().getSimpleName());
        return contactRepository.save(contact);
    }

    public Contact deleteContact(Long id) throws Exception {
        LOG.info("Deleting contact from database {}", this.getClass().getSimpleName());
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            return contactOptional.get();
        }
        throw new Exception("contact not found with id {}" + id);
    }
}
