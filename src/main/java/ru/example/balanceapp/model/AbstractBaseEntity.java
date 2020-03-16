package ru.example.balanceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.balanceapp.HasId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBaseEntity implements HasId {
    public static final int START_SEQ = 100000;

    protected Integer id;
}