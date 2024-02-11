package com.solvd.mobile.models;

import com.zebrunner.carina.utils.R;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserData {
    VALID(R.TESTDATA.get("valid.ntc_login"), R.TESTDATA.get("valid.ntc_pass")),
    INVALID(R.TESTDATA.get("invalid.login"), R.TESTDATA.get("invalid.pass"));

    private final String email;
    private final String pass;
}
