package com.solvd.models;

import com.zebrunner.carina.utils.R;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Users {
    VALID(R.TESTDATA.get("valid.login"), R.TESTDATA.get("valid.password")),
    INVALID(R.TESTDATA.get("invalid.login"), R.TESTDATA.get("invalid.password"));

    private final String username;
    private final String pass;
}
