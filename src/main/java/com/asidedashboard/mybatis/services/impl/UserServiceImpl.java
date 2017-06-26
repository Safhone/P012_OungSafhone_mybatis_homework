package com.asidedashboard.mybatis.services.impl;

import com.asidedashboard.mybatis.model.User;
import com.asidedashboard.mybatis.repositories.UserRepository;
import com.asidedashboard.mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUser() {
        return userRepository.getUser();
    }

    @Override
    public User getUserByHash(String userHash) {
        return userRepository.getUserByHash(userHash);
    }

    @Override
    public boolean addUser(User user) {
        String userHash = UUID.randomUUID().toString();
        user.setUserHash(userHash);
        if(userRepository.addUser(user)) return true;
        else return false;
    }

    @Override
    public boolean updateUser(User user) {
        if(userRepository.updateUser(user)) return true;
        else return false ;
    }

    @Override
    public boolean deleteUser(String userHash) {
        if(userRepository.deleteUser(userHash)) return true;
        else return false;
    }

    @Override
    public int countUser() {
        return userRepository.countUser();
    }

    @Override
    public int countGender(String gender) {
        return userRepository.countGender(gender);
    }

}
