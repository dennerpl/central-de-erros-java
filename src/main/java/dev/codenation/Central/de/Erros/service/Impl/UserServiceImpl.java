package dev.codenation.Central.de.Erros.service.Impl;

import dev.codenation.Central.de.Erros.model.User;
import dev.codenation.Central.de.Erros.repository.UserRepository;
import dev.codenation.Central.de.Erros.service.Interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> FindByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User SaveUser(User user) {
        return userRepository.save(user);
    }
}