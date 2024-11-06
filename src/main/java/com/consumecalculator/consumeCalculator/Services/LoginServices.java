package com.consumecalculator.consumeCalculator.Services;

import com.consumecalculator.consumeCalculator.Entities.LoginClass;
import com.consumecalculator.consumeCalculator.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

    @Autowired
    private UserServices userServices;

    public boolean authenticateUser (LoginClass loginClass) throws Exception {
        User userIdInDb = userServices.getUserById(loginClass.getUserId()).orElseThrow(()->new Exception("User not found with id: "+ loginClass.getUserId()));
        return userIdInDb.getUserId().equals(loginClass.getUserId()) && userIdInDb.getPassword().equals(loginClass.getPassword());
    }
}
