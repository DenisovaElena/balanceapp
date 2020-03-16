package ru.example.balanceapp.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.example.balanceapp.util.UserUtil;
import ru.example.balanceapp.HasLogin;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTo extends BaseTo implements HasLogin, Serializable {
    private static final long serialVersionUID = 1L;

    private String login;

    private String password;

    private Integer balance = UserUtil.DEFAULT_BALANCE;

    public UserTo(Integer id, String login, String password, Integer balance) {
        super(id);
        this.login = login;
        this.password = password;
        this.balance = balance;
    }
}
