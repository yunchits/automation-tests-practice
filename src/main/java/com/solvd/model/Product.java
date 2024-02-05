package com.solvd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Product {
    private Long id;
    private String title;
    private String brand;
    private String category;
}
