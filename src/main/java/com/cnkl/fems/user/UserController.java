package com.cnkl.fems.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user, @RequestParam(name = "type") String type){
        User newUser = userService.createUser(user, type);

        if(newUser == null) return ResponseEntity.badRequest().build();
        else  return ResponseEntity.ok(newUser);
    }
}
