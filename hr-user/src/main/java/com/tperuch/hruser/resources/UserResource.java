package com.tperuch.hruser.resources;

import com.tperuch.hruser.entities.UserEntity;
import com.tperuch.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id){
        UserEntity userEntity = userRepository.findById(id).get();
        return ResponseEntity.ok(userEntity);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<UserEntity> findByEmail(@RequestParam String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        return ResponseEntity.ok(userEntity);
    }
}
