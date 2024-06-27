package br.qziul.controller;

import br.qziul.model.User;
import br.qziul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Utilização do Design Pattern Facade,
 * realizando Abstração do Banco H2 com a API do ViaCEP
 */

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> inserir(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
