package me.dio.desafio_avanade_dio.service.impl;

import me.dio.desafio_avanade_dio.domain.model.User;
import me.dio.desafio_avanade_dio.service.UserService;
import org.springframework.stereotype.Service;
import me.dio.desafio_avanade_dio.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

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
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }

}
