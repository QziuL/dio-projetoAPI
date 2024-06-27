package br.qziul.service.impl;

import br.qziul.model.Endereco;
import br.qziul.model.User;
import br.qziul.repository.EnderecoRepository;
import br.qziul.repository.UserRepository;
import br.qziul.service.UserService;
import br.qziul.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        salvarUserComCep(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) { salvarUserComCep(user); }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private void salvarUserComCep(User user) {
        // Verificar se o Endereço do Cliente já existe (pelo CEP).
        String cep = user.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        user.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereço (novo ou existente).
        userRepository.save(user);
    }
}
