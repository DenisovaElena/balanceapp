package ru.example.balanceapp;

import org.springframework.security.core.authority.AuthorityUtils;
import ru.example.balanceapp.model.User;
import ru.example.balanceapp.to.UserTo;
import ru.example.balanceapp.util.UserUtil;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getLogin(), user.getPassword(), true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
        this.userTo = UserUtil.asTo(user);
    }

    public int getId() {
        return userTo.id();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }
}