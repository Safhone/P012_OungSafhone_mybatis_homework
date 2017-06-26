package com.asidedashboard.mybatis.services;


import com.asidedashboard.mybatis.model.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User getUserByHash(String userHash);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(String userHash);

    int countUser();

    int countGender(String gender);

}
