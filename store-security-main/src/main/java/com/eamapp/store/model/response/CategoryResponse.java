package com.eamapp.store.model.response;

import com.eamapp.store.model.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private List<Category> categorys;
}
