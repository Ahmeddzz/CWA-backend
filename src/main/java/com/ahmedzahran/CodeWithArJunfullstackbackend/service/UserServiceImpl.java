package com.ahmedzahran.CodeWithArJunfullstackbackend.service;

import com.ahmedzahran.CodeWithArJunfullstackbackend.exception.UserNotFoundException;
import com.ahmedzahran.CodeWithArJunfullstackbackend.model.User;
import com.ahmedzahran.CodeWithArJunfullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User createNewUser(User newUser){
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));

    }



    public User updateUser(Long id, User newUser) {
        return userRepository.findById(id)
                .map((user) -> {
                user.setName(newUser.getName());
                user.setUserName(newUser.getUserName());
                user.setEmail(newUser.getEmail());
                user.setDepartment(newUser.getDepartment());
        return userRepository.save(user);
        }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public String deleteUserById(Long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        } else{
            userRepository.deleteById(id);
        }
        return "User with ID " + id + " has been deleted successfully!";
    }
}
