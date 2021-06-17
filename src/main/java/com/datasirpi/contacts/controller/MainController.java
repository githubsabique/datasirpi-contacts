package com.datasirpi.contacts.controller;

import com.datasirpi.contacts.data.repo.Contact;
import com.datasirpi.contacts.data.request.ContactRequest;
import com.datasirpi.contacts.data.response.ContactResponse;

import java.util.ArrayList;
import java.util.List;

import static com.datasirpi.contacts.utils.AppUtils.getInstant;

public class MainController {

    protected Contact mapContact(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setName(contactRequest.getName());
        contact.setMobile(contactRequest.getMobile());
        contact.setEmail(contactRequest.getEmail());
        contact.setDeleted("F");
        contact.setCreatedBy("Logged User"); //TODO Assign currently logged in user.
        contact.setCreatedOn(getInstant());
        contact.setModifiedBy("Logged User"); //TODO Assign currently logged in user.
        contact.setModifiedOn(getInstant());
        return contact;
    }

    protected List<ContactResponse> mapContactResponse(List<Contact> contacts) {

        List<ContactResponse> contactResponseList = new ArrayList<>();
        contacts.forEach(c -> {
            ContactResponse contactResponse = new ContactResponse();
            contactResponse.setId(String.valueOf(c.getId()));
            contactResponse.setName(c.getName());
            contactResponse.setMobile(c.getMobile());
            contactResponse.setEmail(c.getEmail());
            contactResponseList.add(contactResponse);
        });
        return contactResponseList;
    }
}
