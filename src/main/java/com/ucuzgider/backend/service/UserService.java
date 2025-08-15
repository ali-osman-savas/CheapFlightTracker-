package com.ucuzgider.backend.service;

import com.ucuzgider.backend.entity.User;
import com.ucuzgider.backend.repository.BaseRepository;
import com.ucuzgider.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<User, Long> {

    private final UserRepository userRepository;

    @Override
    protected BaseRepository<User, Long> getRepository() {
        return userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}