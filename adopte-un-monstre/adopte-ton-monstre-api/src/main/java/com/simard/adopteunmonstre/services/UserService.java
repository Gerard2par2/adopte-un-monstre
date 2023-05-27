package com.simard.adopteunmonstre.services;

import com.simard.adopteunmonstre.model.entities.User;
import com.simard.adopteunmonstre.repository.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create (User newUser) {
        return this.userRepository.save(newUser);
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    public User updateById(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(updatedUser.getEmail());
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
