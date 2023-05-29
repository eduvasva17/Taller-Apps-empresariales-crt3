package com.eamapp.store.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Blob;

@Data
@Entity
@Table(name = "product", indexes = @Index(name = "idx_name_price_category_maker", unique = true, columnList = "name, price, category_id, maker_id"))
public class Product implements Serializable {
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
