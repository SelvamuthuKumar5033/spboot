package com.kgisl.spb.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.spb.Entity.Users;
import com.kgisl.spb.Service.UsersServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    @PostMapping("/login")
    public ResponseEntity<?> authentication(@RequestBody Users users) {
        boolean exists = usersServices.authenticatesignin(users);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/register")
    public ResponseEntity<Users> createnewuser(@RequestBody Users user) {
        boolean userobj = usersServices.authenticatesignup(user);

        if (user.getRole().isEmpty()) {
            user.setRole("Role_User");
        }
        if (userobj) {
            Users newuser = usersServices.createnewuser(user);
            return new ResponseEntity<>(newuser, HttpStatus.CREATED);   
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/verifyemail")
    public boolean verifyemail(@RequestParam("email") String email) {
        boolean verification = usersServices.verifyemail(email);
        return verification;
    }

    @PatchMapping("/resetpassword")
    public String resetpassword(@RequestBody Map<String, String> data) {

        String email = data.get("email");
        String newpass = data.get("newpass");
        String olduser = usersServices.resetpassword(email, newpass);
        return olduser;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return ResponseEntity.ok().build();
    }
}
