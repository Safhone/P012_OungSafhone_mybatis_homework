package com.asidedashboard.mybatis.repositories;

import com.asidedashboard.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    /*
    * Get Data From Database Table User
    * */
    @Select("SELECT id, username, email, gender, " +
            "phonenumber, status, user_hash, " +
            "created_date FROM users " +
            "ORDER BY id")
    @Results(value = {
            @Result(property = "userHash", column = "user_hash"),
            @Result(property = "createdDate", column = "created_date")
    })
    public List<User> getUser();

    /*
    * Get Data By user_hash
    * */

    @Select("SELECT username, email, gender, " +
            "phonenumber, user_hash FROM users " +
            "WHERE user_hash = #{userHash}")
    @Results(value = {
            @Result(property = "userHash", column = "user_hash")
    })
    public User getUserByHash(@Param("userHash") String userHash);

    /*
    * Insert User
    **/
    @Insert("INSERT INTO users (username, email, gender, phonenumber, user_hash)" +
            "VALUES (#{user.username}, #{user.email}, #{user.gender}, " +
            "#{user.phoneNumber}, #{user.userHash})")
    public boolean addUser(@Param("user") User user);

    /*
    *    Delete User
    * */
    @Delete("DELETE FROM users WHERE user_hash = #{userHash}")
    public boolean deleteUser(@Param("userHash") String userHash);


    /*
    * Update User
    * */
    @Update("UPDATE users SET " +
            "username = #{user.username}, " +
            "email = #{user.email}, " +
            "gender = #{user.gender}, " +
            "phonenumber = #{user.phoneNumber} " +
            "WHERE user_hash = #{user.userHash}")
    public boolean updateUser(@Param("user") User user);


    @Select("SELECT COUNT(id) FROM users")
    public int countUser();

    @Select("SELECT COUNT(id) FROM users WHERE gender = #{gender}")
    public int countGender(@Param("gender") String gender);


}
