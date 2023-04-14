package com.ahmedzahran.CodeWithArJunfullstackbackend.service;

import com.ahmedzahran.CodeWithArJunfullstackbackend.model.User;

import java.util.List;

public interface UserService {
    User createNewUser(User newUser);
    List<User> getAllUsers();
    User getUserById(Long id);

    User updateUser(Long id,User newUser);

    String deleteUserById(Long id);
}
