package ru.example.balanceapp.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import ru.example.balanceapp.model.User;
import ru.example.balanceapp.to.UserTo;

public class UserUtil {

    public static final int DEFAULT_BALANCE = 0;

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getLogin(), userTo.getPassword(), userTo.getBalance());
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getLogin(), user.getPassword(), user.getBalance());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setLogin(userTo.getLogin());
        user.setPassword(userTo.getPassword());
        user.setBalance(user.getBalance());
        return user;
    }

    public static User prepareToSave(User user, PasswordEncoder passwordEncoder) {
        String password = user.getPassword();
        user.setPassword(StringUtils.hasText(password) ? passwordEncoder.encode(password) : password);
        return user;
    }
}