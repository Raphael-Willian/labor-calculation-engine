package com.engine.calculator.controllers;


import com.engine.calculator.models.User;
import com.engine.calculator.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    //Injetado via construtor, porém, @Autowired numa possível refatoração futura.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User userRequest) {

        User responseUser = userService.create(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);

    }

    @GetMapping()
    public ResponseEntity<User> readUsers() {

        List<User> userResponse = userService.read();

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/{idUser}")
    public ResponseEntity<User> updateUser(@RequestParam UUID idUser, @RequestBody User userRequest) {

        userService.update(idUser, userRequest);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<User> deleteUser(@RequestParam UUID idUser) {

        userService.delete(idUser);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

}
