package com.estraMyPime.backend.Controller;



import com.estraMyPime.backend.Model.User;

import com.estraMyPime.backend.Model.UserDTO;
import com.estraMyPime.backend.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "User Controller", description = "Controlador para los usuarios y sus operaciones")

public class UserController {

    @Autowired
    private UserService userService;
    @Operation(summary = "Obtener todos los usuarios existentes")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @Operation(summary = "Obtener un usuario por id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(summary = "Crear un nuevo Usuario")
    @PostMapping
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        Map<String, String> response = userService.createUser(user);
        if (response.containsKey("error")) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @Operation(summary = "Actualizar un Usuario")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> updatedUserOpt = userService.updateUser(id, user);
        if (!updatedUserOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUserOpt.get());
    }
    @Operation(summary = "Borrar un  Usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Endpoint para actualizar el campo isTestDone de un usuario específico")

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUserIsTestDone(@PathVariable Long id, @RequestBody User userUpdate) {
        try {
            userService.updateIsTestDone(id, userUpdate.isTestDone());
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @Operation(summary = "Endpoint para actualizar el campo isTestDone de un usuario específico pasando tambien el parametro")
    @PatchMapping("/{userId}/test-done")
    public ResponseEntity<?> updateTestDone(@PathVariable Long userId, @RequestBody Map<String, Boolean> isTestDone) {
        boolean testDone = isTestDone.getOrDefault("isTestDone", false);
        userService.updateIsTestDone(userId, testDone);
        return ResponseEntity.ok().build();
    }

}
