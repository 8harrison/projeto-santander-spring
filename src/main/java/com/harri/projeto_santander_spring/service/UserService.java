package com.harri.projeto_santander_spring.service;

import com.harri.projeto_santander_spring.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
