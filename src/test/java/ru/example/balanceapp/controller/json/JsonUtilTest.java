package ru.example.balanceapp.controller.json;

import org.junit.jupiter.api.Test;
import ru.example.balanceapp.UserTestData;
import ru.example.balanceapp.model.User;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonUtilTest {
    @Test
    void writeOnlyAccess() throws Exception {
        String json = JsonUtil.writeValue(UserTestData.USER1);
        System.out.println(json);
        assertThat(json, not(containsString("password")));
        String jsonWithPass = JsonUtil.writeAdditionProps(UserTestData.USER1, "password", "newPass");
        System.out.println(jsonWithPass);
        User user = JsonUtil.readValue(jsonWithPass, User.class);
        assertEquals(user.getPassword(), "newPass");
    }
}