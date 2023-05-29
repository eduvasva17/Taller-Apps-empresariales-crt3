package com.eamapp.store.model.response;

import lombok.Data;

import java.util.List;
import com.eamapp.store.model.entity.Category;

@Data
public class CategoryResponse {
    private List<Category> categorys;

}
