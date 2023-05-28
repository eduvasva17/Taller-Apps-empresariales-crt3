package com.eamapp.store.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "maker", indexes = @Index(name = "idx_name", unique = true, columnList = "name"))
public class Maker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Serial
    private static final long serialVersionUID = -7299273303425471644L;
}
