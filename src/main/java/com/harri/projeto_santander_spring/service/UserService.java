package com.harri.projeto_santander_spring.service;

import com.harri.projeto_santander_spring.domain.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

    Page<User> findAll(int pagina, int itens);

    User update(Long id, User user);

    String delete(Long id);
}
