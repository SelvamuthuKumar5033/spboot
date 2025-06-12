package com.kgisl.spb.Repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.spb.Entity.Users;

@Repository
public interface UsersRepository extends ListCrudRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);
    // Optional<Users> findByUsernameOrEmail(String username, String email);
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByRole(String role);
    // Boolean existsByEmail(String email);

}
