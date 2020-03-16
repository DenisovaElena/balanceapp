package ru.example.balanceapp.controller.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.example.balanceapp.TestUtil;
import ru.example.balanceapp.UserTestData;
import ru.example.balanceapp.model.User;
import ru.example.balanceapp.service.UserService;
import ru.example.balanceapp.to.UserTo;
import ru.example.balanceapp.util.UserUtil;
import ru.example.balanceapp.util.exception.ErrorType;
import ru.example.balanceapp.controller.ExceptionInfoHandler;
import ru.example.balanceapp.controller.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

class ProfileRestControllerTest extends AbstractControllerTest {

    @Autowired
    private UserService userService;

    ProfileRestControllerTest() {
        super(ProfileRestController.REST_URL);
    }

    @Test
    void get() throws Exception {
        perform(doGet().basicAuth(UserTestData.USER1))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(UserTestData.USER_MATCHERS.contentJson(UserTestData.USER1));
    }


    @Test
    void register() throws Exception {
        UserTo newTo = new UserTo(null, "newLogin", "newPassword", 0);
        User newUser = UserUtil.createNewFromTo(newTo);
        ResultActions action = perform(doPost("/register").jsonBody(newTo))
                .andDo(print())
                .andExpect(status().isCreated());

        User created = TestUtil.readFromJson(action, User.class);
        Integer newId = created.getId();
        newUser.setId(newId);
        UserTestData.USER_MATCHERS.assertMatch(created, newUser);
        UserTestData.USER_MATCHERS.assertMatch(userService.get(newId), newUser);
    }
}