package com.estraMyPime.backend.Controller;



import com.estraMyPime.backend.Model.User;

import com.estraMyPime.backend.Model.UserDTO;
import com.estraMyPime.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")


public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        // Verificar si el email ya existe
        if (userService.emailExists(user.getEmail())) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email already in use.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Verificar si el ID ya existe
        if (userService.getUserById(user.getId()).isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "User ID already exists.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Crear el nuevo usuario
        User createdUser = userService.saveUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User created successfully with ID: " + createdUser.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        // Verificar si el usuario existe
        Optional<User> existingUserOpt = userService.getUserById(id);
        if (!existingUserOpt.isPresent()) {
            return ResponseEntity.notFound().build(); // Usuario no encontrado
        }

        User existingUser = existingUserOpt.get();

        // Actualizar los campos del usuario
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setTypeUser(userDTO.getTypeUser());
        existingUser.setSizeCompany(userDTO.getSizeCompany());
        existingUser.setSector(userDTO.getSector());
        existingUser.setBookDownloaded(userDTO.isBookDownloaded());
        existingUser.setTestDone(userDTO.isTestDone());

        // Guardar el usuario actualizado
        User savedUser = userService.saveUser(existingUser);

        // Convertir la entidad de vuelta al DTO para la respuesta
        UserDTO savedUserDTO = new UserDTO();
        savedUserDTO.setId(savedUser.getId());
        savedUserDTO.setName(savedUser.getName());
        savedUserDTO.setEmail(savedUser.getEmail());
        savedUserDTO.setPassword(savedUser.getPassword());
        savedUserDTO.setTypeUser(savedUser.getTypeUser());
        savedUserDTO.setSizeCompany(savedUser.getSizeCompany());
        savedUserDTO.setSector(savedUser.getSector());
        savedUserDTO.setBookDownloaded(savedUser.isBookDownloaded());
        savedUserDTO.setTestDone(savedUser.isTestDone());

        return ResponseEntity.ok(savedUserDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


