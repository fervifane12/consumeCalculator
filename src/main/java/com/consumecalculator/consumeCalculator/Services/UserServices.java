package com.consumecalculator.consumeCalculator.Services;

import com.consumecalculator.consumeCalculator.Entities.User;
import com.consumecalculator.consumeCalculator.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User saveUser (User user) throws Exception{

        if (userRepository.existsById(user.getUserId())){
            throw new Exception("User already in the DataBase, please user a different ID");
        } else {
            return userRepository.save(user);
        }
    }

    public Optional<User> getUserById (String userId){
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers (){
        return userRepository.findAll();
    }

    public void deleteUser (String userId){
        userRepository.deleteById(userId);
    }

    public User updateUser (User user) throws Exception{
        User userInDB = getUserById(user.getUserId()).orElseThrow(()-> new Exception("User not found with ID: " + user.getUserId()) );

        if (!user.getFull_name().equals(userInDB.getFull_name())){
            userInDB.setFull_name(user.getFull_name());}

        if (!user.getEmail().equals(userInDB.getEmail())){
            userInDB.setEmail(user.getEmail());}

        if (!user.getPassword().equals(userInDB.getPassword())){
            userInDB.setPassword(user.getPassword());}

        if (!user.getAddress().equals(userInDB.getAddress())){
            userInDB.setAddress(user.getAddress());}

        return userRepository.save(userInDB);
    }


}