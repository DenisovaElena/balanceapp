package ru.example.balanceapp.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import ru.example.balanceapp.model.User;
import ru.example.balanceapp.service.UserService;
import ru.example.balanceapp.to.UserTo;
import ru.example.balanceapp.util.UserUtil;
import static ru.example.balanceapp.util.ValidationUtil.assureIdConsistent;
import static ru.example.balanceapp.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(UserTo userTo) {
        log.info("create from to {}", userTo);
        return create(UserUtil.createNewFromTo(userTo));
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public void update(UserTo userTo, int id) {
        log.info("update {} with id={}", userTo, id);
        assureIdConsistent(userTo, id);
        service.update(userTo);
    }

    public User getByLogin(String login) {
        log.info("getByLogin {}", login);
        return service.getByLogin(login);
    }

}