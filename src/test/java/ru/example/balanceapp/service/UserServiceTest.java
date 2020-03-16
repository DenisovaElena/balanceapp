package ru.example.balanceapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import ru.example.balanceapp.UserTestData;
import ru.example.balanceapp.model.User;
import ru.example.balanceapp.util.exception.NotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    protected UserService service;

    @Test
    void create() throws Exception {
        User newUser = UserTestData.getNew();
        User created = service.create(new User(newUser));
        Integer newId = created.getId();
        newUser.setId(newId);
        UserTestData.USER_MATCHERS.assertMatch(created, newUser);
        UserTestData.USER_MATCHERS.assertMatch(service.get(newId), newUser);
    }

    @Test
    void duplicateLoginCreate() throws Exception {
        assertThrows(DataAccessException.class, () ->
                service.create(new User("user1", "Duplicate", 0)));
    }

    @Test
    void delete() throws Exception {
        service.delete(UserTestData.USER_ID);
        assertThrows(NotFoundException.class, () ->
                service.delete(UserTestData.USER_ID));
    }

    @Test
    void deletedNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.delete(1));
    }

    @Test
    void get() throws Exception {
        User user = service.get(UserTestData.USER_ID);
        UserTestData.USER_MATCHERS.assertMatch(user, UserTestData.USER1);
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.get(1));
    }

    @Test
    void getByLogin() throws Exception {
        User user = service.getByLogin("user1");
        UserTestData.USER_MATCHERS.assertMatch(user, UserTestData.USER1);
    }

    @Test
    void update() throws Exception {
        User updated = UserTestData.getUpdated();
        service.update(new User(updated));
        UserTestData.USER_MATCHERS.assertMatch(service.get(UserTestData.USER_ID), updated);
    }

    @Test
    void getAll() throws Exception {
        List<User> all = service.getAll();
        UserTestData.USER_MATCHERS.assertMatch(all, UserTestData.USER1, UserTestData.USER2);
    }
}