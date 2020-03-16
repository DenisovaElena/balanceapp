package ru.example.balanceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.example.balanceapp.HasLogin;

import static ru.example.balanceapp.util.UserUtil.DEFAULT_BALANCE;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractBaseEntity implements HasLogin {

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Integer balance = DEFAULT_BALANCE;

    public User(Integer id, String login, String password, Integer balance) {
        super(id);
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public User(User updated) {
        this.id = updated.getId();
        this.login = updated.getLogin();
        this.password = updated.getPassword();
        this.balance = updated.getBalance();
    }
}