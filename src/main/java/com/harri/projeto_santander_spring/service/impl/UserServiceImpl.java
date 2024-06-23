package com.harri.projeto_santander_spring.service.impl;

import com.harri.projeto_santander_spring.domain.model.User;
import com.harri.projeto_santander_spring.domain.repository.UserRepository;
import com.harri.projeto_santander_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This User ID already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
