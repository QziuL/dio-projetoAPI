package br.qziul.service;

import br.qziul.model.User;

public interface UserService {
    Iterable<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
