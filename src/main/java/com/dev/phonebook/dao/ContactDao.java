package com.dev.phonebook.dao;

import com.dev.phonebook.entity.Contact;

public interface ContactDao {

    // CRUD

    void createContact(Contact c);

    // QUERIES

    Contact getContactByEmail(String email);

    Contact getContactByPhone(String phone);

}
