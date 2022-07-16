package com.dev.phonebook.dao;

import com.dev.phonebook.entity.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContactDao {

    // CRUD

    @Insert("insert into contacts (firstname, lastname, email, phone, avatar, address, city, state, pincode, country, user_id, created_at)" +
            " values (#{firstname}, #{lastname}, #{email}, #{phone}, #{avatar}, #{address}, #{city}, #{state}, #{pincode}, #{country}," +
            " #{userId}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createContact(Contact c);

    @Select("select * from contacts where id = #{id} and user_id=#{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt")
    })
    Contact getContact(@Param("id") Integer id, @Param("userId") Integer userId);

    @Update("update contacts set firstname=#{firstname}, lastname=#{lastname}, email=#{email}, phone=#{phone}, " +
            "avatar=#{avatar}, address=#{address}, city=#{city}, state=#{state}, pincode=#{pincode}, country=#{country}, " +
            "user_id=#{userId} where id = #{id}")
    void updateContact(Contact c);

    @Delete("delete from contacts where id = #{id}")
    void deleteContact(Integer id);

    // QUERIES

    @Select("select * from contacts where email = #{email}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt")
    })
    Contact getContactByEmail(String email);

    @Select("select * from contacts where user_id = #{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt")
    })
    List<Contact> getAllContacts(Integer userId);

    @Select("select * from contacts where phone = #{phone}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt")
    })
    Contact getContactByPhone(String phone);

}
