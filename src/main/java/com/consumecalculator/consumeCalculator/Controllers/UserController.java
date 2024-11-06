package com.consumecalculator.consumeCalculator.Controllers;

import com.consumecalculator.consumeCalculator.Entities.User;
import com.consumecalculator.consumeCalculator.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) throws Exception {
        User saveUser = userServices.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userId}")
    public Optional<User> getUserById(@PathVariable String userId){
        return userServices.getUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @DeleteMapping("/{userId}")

    public ResponseEntity<Void> deleteUserById(@PathVariable String userId){
        userServices.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
        User updateUser = userServices.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.ACCEPTED);
    }
}
