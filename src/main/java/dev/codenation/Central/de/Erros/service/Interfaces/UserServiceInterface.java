package dev.codenation.Central.de.Erros.service.Interfaces;

import dev.codenation.Central.de.Erros.model.User;

import java.util.Optional;

public interface UserServiceInterface{

    public Optional<User> FindByEmail(String email);

    public User SaveUser(User user);

}
