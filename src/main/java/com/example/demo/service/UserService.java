package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public UserEntity getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public UserEntity updateUser(Long id, UserEntity userDetails) {
        UserEntity user = repository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        return repository.save(user);
    }
}