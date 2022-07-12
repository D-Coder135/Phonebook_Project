package com.dev.phonebook.dao;

import com.dev.phonebook.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    //CRUD
    public void createUser(User user);

    //Queries
    @Select("Select * from users where email = #{email}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    public User getUserByEmail(String email);
}
