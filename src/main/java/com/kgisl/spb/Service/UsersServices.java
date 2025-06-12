package com.kgisl.spb.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.spb.Entity.Users;
import com.kgisl.spb.Repository.UsersRepository;

@Service
public class UsersServices {

    @Autowired
    private UsersRepository usersRepository;

    // private final BCryptPasswordEncoder passwordEncoder = new
    // BCryptPasswordEncoder();

    public boolean authenticatesignin(Users user) {
        Optional<Users> userOpt = usersRepository.findByUsername(user.getUsername());

        if (userOpt.isEmpty()) {
            return false;
        }

        if (userOpt.get().getUsername().equals(user.getUsername())
                && userOpt.get().getPassword().equals(user.getPassword())) {
            return true;
        }

        return false;
    }

    public boolean authenticatesignup(Users user) {
        Optional<Users> userOpt = usersRepository.findByUsername(user.getUsername());

        if (userOpt.isEmpty()) {
            return true;
        }

        if (user.getPassword().length() > 6) {
            return true;
        }

        return false;
    }

    public Users createnewuser(Users users) {
        return usersRepository.save(users);
    }

    public boolean verifyemail(String email){
        Optional<Users> oldusers = this.usersRepository.findByEmail(email);

        if(!oldusers.isPresent()){
            return false;
        }
        return true;
    }

    public String resetpassword(String email, String newpassword) {
        Optional<Users> oldusers = this.usersRepository.findByEmail(email);
        Users newuser = oldusers.get();
        if (newpassword != null && !newpassword.isEmpty()) {
            newuser.setPassword(newpassword);
            return usersRepository.save(newuser)!=null? "Reset successfully":"Reset unsuccessfull";
        }
        return "Something went wrong !!";
    }


    
    


}