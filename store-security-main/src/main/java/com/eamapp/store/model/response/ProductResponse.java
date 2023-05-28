package com.eamapp.store.model.response;

import com.eamapp.store.model.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private List<Product> products;
}
