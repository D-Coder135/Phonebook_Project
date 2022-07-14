package com.dev.phonebook.dao;

import com.dev.phonebook.entity.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ContactDao {

    // CRUD

    @Insert("insert into contacts (firstname, lastname, email, phone, avatar, address, city, state, pincode, country, user_id, created_at)" +
            " values (#{firstname}, #{lastname}, #{email}, #{avatar}, #{address}, #{city}, #{state}, #{pincode}, #{country}," +
            " #{userId}, #{createdAt})")
    void createContact(Contact c);

    // QUERIES

    @Select("select * from contacts where email = #{email}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt")
    })
    Contact getContactByEmail(String email);

    @Select("select * from contacts where phone = #{phone}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt")
    })
    Contact getContactByPhone(String phone);

}
