package com.pombalGustavo.Password_Generator.model;

public class PasswordOptions {
    private static final String textSimbols = "\"!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~\"";
    private static final String textUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String textLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String textNumbers = "0123456789";

    private boolean simbols;
    private boolean upperCase;
    private boolean lowerCase;
    private boolean numbers;
    private Integer passwordLength;

    public PasswordOptions() {
    }

    public PasswordOptions(boolean simbols, boolean upperCase, boolean lowerCase, boolean numbers, Integer passwordLength) {
        this.simbols = simbols;
        this.upperCase = upperCase;
        this.lowerCase = lowerCase;
        this.numbers = numbers;
        this.passwordLength = passwordLength;
    }

    public boolean isSimbols() {
        return simbols;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public boolean isLowerCase() {
        return lowerCase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public Integer getPasswordLength() {
        return passwordLength;
    }
}
