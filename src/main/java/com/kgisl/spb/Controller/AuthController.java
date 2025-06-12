package com.kgisl.spb.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.spb.Entity.TokenAuth;
import com.kgisl.spb.Service.AuthServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/token")
public class AuthController {

    @Autowired
    private AuthServices authServices;

    @PostMapping("/auth")
    public ResponseEntity<TokenAuth> tokenauth(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        TokenAuth token = authServices.getaccesstoken(username, password);

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(token);
    }
}
