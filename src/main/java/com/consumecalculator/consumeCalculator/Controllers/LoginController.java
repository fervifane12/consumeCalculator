package com.consumecalculator.consumeCalculator.Controllers;

import com.consumecalculator.consumeCalculator.Entities.LoginClass;
import com.consumecalculator.consumeCalculator.Services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServices loginServices;

    @PostMapping
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginClass loginClass) throws Exception {
        HashMap<String, String> response= new HashMap<>();
        if (loginServices.authenticateUser(loginClass)){
            response.put("message", "Login successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Invalid credentials");
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
