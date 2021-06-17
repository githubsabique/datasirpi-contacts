package com.datasirpi.contacts.controller;

import com.datasirpi.contacts.data.request.ContactRequest;
import com.datasirpi.contacts.data.response.ContactResponse;
import com.datasirpi.contacts.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController extends MainController {

    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Autowired
    ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContacts() {
        LOG.info("Get list of all contacts {}", this.getClass().getSimpleName());
        List<ContactResponse> contactResponseList = mapContactResponse(contactService.listContacts());
        return new ResponseEntity<>(contactResponseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addContacts(@RequestBody ContactRequest contactRequest) {
        LOG.info("Add new contact {}", this.getClass().getSimpleName());
        contactService.saveContact(mapContact(contactRequest));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContact(@PathVariable Long id) throws Exception {
        LOG.info("Delete existing contact {}", this.getClass().getSimpleName());
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
