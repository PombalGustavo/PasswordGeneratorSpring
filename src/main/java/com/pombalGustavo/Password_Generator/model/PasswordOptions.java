package com.pombalGustavo.Password_Generator.model;

public class PasswordOptions {

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

    public void setSimbols(boolean simbols) {
        this.simbols = simbols;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public boolean isLowerCase() {
        return lowerCase;
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public Integer getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(Integer passwordLength) {
        this.passwordLength = passwordLength;
    }
}
