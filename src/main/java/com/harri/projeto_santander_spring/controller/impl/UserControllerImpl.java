package com.harri.projeto_santander_spring.controller.impl;

import com.harri.projeto_santander_spring.controller.UserController;
import com.harri.projeto_santander_spring.domain.model.User;
import com.harri.projeto_santander_spring.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> create(User user) {
        User userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @Override
    public ResponseEntity<Page<User>> findAll(int pagina, int itens) {
        Page<User> users = userService.findAll(pagina, itens);
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> update(Long id, User user) {
        User userUpdated = userService.update(id, user);
        return ResponseEntity.ok(userUpdated);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        String message = userService.delete(id);
        return ResponseEntity.ok(message);
    }
}
