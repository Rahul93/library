package com.example.library.model;

import com.example.library.enums.AccountType;
import com.example.library.utils.Constants;

import javax.persistence.*;

@MappedSuperclass
@Entity
@Table(name = Constants.Database.ACCOUNT_TABLE)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Enumerated(EnumType.STRING)
    private AccountType entity_type;

    private String name;
    private String status;
    private String role;
}
