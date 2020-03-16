package ru.example.balanceapp.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.example.balanceapp.AuthorizedUser;
import ru.example.balanceapp.model.User;
import ru.example.balanceapp.to.UserTo;
import java.net.URI;

@RestController
@RequestMapping(value = ProfileRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRestController extends AbstractUserController {
    static final String REST_URL = "/rest/profile";

    @GetMapping
    public User get(@AuthenticationPrincipal AuthorizedUser authUser) {
        return super.get(authUser.getId());
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User register(@RequestBody UserTo userTo) {
        return super.create(userTo);
    }
}