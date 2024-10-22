package com.estraMyPime.backend.Service;


import com.estraMyPime.backend.Model.TypeUser;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Este Email ya esta en uso");
        }

        user.setTypeUser(mapTypeUser(user.getTypeUser()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {

        userDetails.setTypeUser(mapTypeUser(userDetails.getTypeUser()));

        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    user.setTypeUser(userDetails.getTypeUser());
                    user.setSizeCompany(userDetails.getSizeCompany());
                    user.setSector(userDetails.getSector());
                    user.setBookDownloaded(userDetails.isBookDownloaded());
                    user.setTestDone(userDetails.isTestDone());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User No encontrado con ese ID " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //metodo para mapear lo que se recibe del front al enum para luego enviar a la db
    private TypeUser mapTypeUser(TypeUser typeUser) {
        switch (typeUser.ordinal()) {
            case 1:
                return TypeUser.natural;
            case 2:
                return TypeUser.juridica;
            default:
                throw new IllegalArgumentException("Invalid typeUser value: " + typeUser);
        }
    }
}
