package c0920g1.service;

import c0920g1.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
