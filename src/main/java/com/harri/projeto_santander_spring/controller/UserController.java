package com.harri.projeto_santander_spring.controller;

import com.harri.projeto_santander_spring.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/users")
public interface UserController {

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<User> create(@RequestBody User user);

    @GetMapping
    ResponseEntity<Page<User>> findAll(@RequestParam int pagina, @RequestParam int itens);

    @PutMapping("/{id}")
    ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user);

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id);
}
