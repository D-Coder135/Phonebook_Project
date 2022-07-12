package com.dev.phonebook.dao;

import com.dev.phonebook.entity.User;

public interface UserDao {

    //CRUD

    //Queries
    public User getUserByEmail(String email);
}
