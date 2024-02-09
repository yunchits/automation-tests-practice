package com.solvd.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Languages {

    ENGLISH("English"),
    RUSSIAN("Русский");

    private final String name;
}