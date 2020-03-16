package ru.example.balanceapp.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.balanceapp.HasId;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BaseTo implements HasId {
    protected Integer id;
}
