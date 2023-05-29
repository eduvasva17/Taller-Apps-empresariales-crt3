package com.eamapp.store.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category", indexes = @Index(name = "idx_name_description", unique = true, columnList = "name, description"))
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Serial
    private static final long serialVersionUID = -7299273303425471645L;
}
