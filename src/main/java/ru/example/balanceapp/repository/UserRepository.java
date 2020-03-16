package ru.example.balanceapp.repository;

import ru.example.balanceapp.model.User;

import java.util.List;

public interface UserRepository {
    // null if not found, when updated
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByLogin(String login);

    List<User> getAll();
}