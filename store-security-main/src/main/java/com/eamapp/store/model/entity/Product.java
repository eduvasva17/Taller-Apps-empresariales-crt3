package com.eamapp.store.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product", indexes = @Index(name = "idx_name", unique = true, columnList = "name",  columnList = "price",  columnList = "category_id",  columnList = "maker_id"))
public class Maker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Blob picture;
    private Long category_id;
    private Long maker_id;

    @Serial
    private static final long serialVersionUID = -7299273303425471646L;
}
