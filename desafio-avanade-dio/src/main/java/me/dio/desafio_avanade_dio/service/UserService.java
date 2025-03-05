package me.dio.desafio_avanade_dio.service;

import me.dio.desafio_avanade_dio.domain.model.User;

public interface UserService {
    User findById (Long id);
    User create(User userToCreate);
}
