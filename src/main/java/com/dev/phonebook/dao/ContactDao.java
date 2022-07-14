package com.dev.phonebook.dao;

import com.dev.phonebook.entity.Contact;
import org.apache.ibatis.annotations.Insert;

public interface ContactDao {

    // CRUD

    @Insert("insert into contacts (firstname, lastname, email, phone, avatar, address, city, state, pincode, country, user_id, created_at)" +
            " values (#{firstname}, #{lastname}, #{email}, #{avatar}, #{address}, #{city}, #{state}, #{pincode}, #{country}," +
            " #{userId}, #{createdAt})")
    void createContact(Contact c);

    // QUERIES

    Contact getContactByEmail(String email);

    Contact getContactByPhone(String phone);

}
