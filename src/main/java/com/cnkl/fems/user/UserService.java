package com.cnkl.fems.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user, String type){
        User newUser = UserFactory.createUser(user, type);

        if(newUser == null) return null;
        else return userRepository.save(newUser);
    }
}
