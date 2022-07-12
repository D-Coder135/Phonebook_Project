package com.dev.phonebook.dao;

import com.dev.phonebook.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    //CRUD
    @Insert("insert into users (name, email, password, created_at) values (#{name}, #{email}, #{password}, #{createdAt})")

    public void createUser(User user);

    //Queries
    @Select("Select * from users where email = #{email}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    public User getUserByEmail(String email);
}
