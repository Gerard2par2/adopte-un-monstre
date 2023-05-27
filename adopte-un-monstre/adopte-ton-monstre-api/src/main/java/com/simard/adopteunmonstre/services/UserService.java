package com.simard.adopteunmonstre.services;

import com.simard.adopteunmonstre.model.entities.User;
import com.simard.adopteunmonstre.model.entities.dto.user.UserLoginEmailDto;
import com.simard.adopteunmonstre.model.entities.dto.user.UserLoginUserNameDto;
import com.simard.adopteunmonstre.repository.UserRepository;
import com.simard.adopteunmonstre.exception.DuplicatedEntryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        // Check that email is unique
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicatedEntryException("Email already exists");
        }

        // Check that username is unique
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicatedEntryException("Username already exists");
        }

        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save a new user
        userRepository.save(user);
        return user;
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

    public boolean loginWithEmail(UserLoginEmailDto user) {
        String hashedPassword = this.userRepository.findByEmail(user.getEmail()).getPassword();
        return this.passwordEncoder.matches(user.getPassword(), hashedPassword);
    }

    public boolean loginWithUserName(UserLoginUserNameDto user) {
        String hashedPassword = this.userRepository.findByUsername(user.getUsername()).getPassword();
        return this.passwordEncoder.matches(user.getPassword(), hashedPassword);
    }
}
