package com.eamapp.store.model.response;

import com.eamapp.store.model.entity.Maker;
import lombok.Data;

import java.util.List;

@Data
public class MakerResponse {
    private List<Maker> makers;
}
