package com.harri.projeto_santander_spring.service.impl;

import com.harri.projeto_santander_spring.domain.model.User;
import com.harri.projeto_santander_spring.domain.repository.UserRepository;
import com.harri.projeto_santander_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This User ID already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public Page<User> findAll(int pagina, int itens) {
        return userRepository.findAll(PageRequest.of(pagina, itens));
    }

    @Override
    public User update(Long id, User user) {
        if (!userRepository.existsById(id)){
            throw new NoSuchElementException("This User ID no exists");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public String delete(Long id) {
        if (!userRepository.existsById(id)){
            throw new NoSuchElementException("This User ID no exists");
        }
        userRepository.deleteById(id);
        return "The User with ID %s was excluded".formatted(id);
    }
}
