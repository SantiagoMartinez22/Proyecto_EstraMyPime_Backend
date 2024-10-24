package com.estraMyPime.backend.Service;


import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Map<String, String> createUser(User user) {
        Map<String, String> response = new HashMap<>();

        if (emailExists(user.getEmail())) {
            response.put("error", "Email already in use.");
            return response;
        }

        if (getUserById(user.getId()).isPresent()) {
            response.put("error", "User ID already exists.");
            return response;
        }

        User createdUser = saveUser(user);
        response.put("message", "User created successfully with ID: " + createdUser.getId());
        return response;
    }

    public Optional<User> updateUser(Long id, User user) {
        Optional<User> existingUserOpt = getUserById(id);
        if (!existingUserOpt.isPresent()) {
            return Optional.empty(); // Usuario no encontrado
        }

        User existingUser = existingUserOpt.get();

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setTypeUser(user.getTypeUser());
        existingUser.setSizeCompany(user.getSizeCompany());
        existingUser.setSector(user.getSector());
        existingUser.setBookDownloaded(user.isBookDownloaded());
        existingUser.setTestDone(user.isTestDone());

        User savedUser = saveUser(existingUser);

        return Optional.of(savedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

