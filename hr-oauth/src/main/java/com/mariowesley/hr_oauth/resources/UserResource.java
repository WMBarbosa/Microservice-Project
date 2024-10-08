package com.mariowesley.hr_oauth.resources;

import com.mariowesley.hr_oauth.entities.User;
import com.mariowesley.hr_oauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findyEmail(@RequestParam String email) {
        try {
            User user = userService.findyEmail(email);
            return ResponseEntity.ok(user);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
