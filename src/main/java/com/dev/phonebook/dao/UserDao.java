package com.dev.phonebook.dao;

import com.dev.phonebook.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    //CRUD

    //Queries
    @Select("Select * from users where email = #{email}")
    public User getUserByEmail(String email);
}
