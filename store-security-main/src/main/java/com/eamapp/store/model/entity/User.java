package com.eamapp.store.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "user", indexes = @Index(name = "idx_name", columnList = "name"))
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Serial
    private static final long serialVersionUID = -7695125717685165309L;
}
