package ru.example.balanceapp;

import ru.example.balanceapp.model.User;

import static ru.example.balanceapp.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER_ID = START_SEQ;

    public static final User USER1 = new User(USER_ID, "user1", "user1",  100);
    public static final User USER2 = new User(USER_ID + 1, "user2", "user2", 10);

    public static User getNew() {
        return new User(null, "new", "newPass", 0);
    }

    public static User getUpdated() {
        User updated = new User(USER1);
        return updated;
    }

    public static TestMatchers<User> USER_MATCHERS = TestMatchers.useFieldsComparator(User.class,"password");
}
