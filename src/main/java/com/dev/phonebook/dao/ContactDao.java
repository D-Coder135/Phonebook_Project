package com.dev.phonebook.dao;

import com.dev.phonebook.entity.Contact;

public interface ContactDao {
    Contact getContactByEmail(String email);
}
