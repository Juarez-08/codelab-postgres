package datapostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import datapostgres.data.entity.User;
import datapostgres.data.repository.UserRepository;
import datapostgres.data.exception.UserNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    // Crear un nuevo usuario
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con id: " + id));
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public User modifyUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con id: " + id));
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
