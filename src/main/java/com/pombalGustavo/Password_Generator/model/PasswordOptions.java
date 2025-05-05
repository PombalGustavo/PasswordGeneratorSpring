package com.pombalGustavo.Password_Generator.model;

import com.pombalGustavo.Password_Generator.exception.PasswordException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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

    public String validateOptions() {
        StringBuilder sb = new StringBuilder();

        if (isSimbols()) {
            sb.append(textSimbols);
        }
        if (isUpperCase()) {
            sb.append(textUpperCase);
        }
        if (isLowerCase()) {
            sb.append(textLowerCase);
        }
        if (isNumbers()) {
            sb.append(textNumbers);
        }

        if (sb.isEmpty()) {
            throw new PasswordException("Erro! Nenhuma opção para a senha foi escolhida");
        }

        return sb.toString();
    }

    public String generateRandomPassword(String passwordOptions) {

        StringBuilder sb = new StringBuilder();

        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

            for (int i = 0; i < passwordLength; i++) {
                int randomInt = secureRandom.nextInt(passwordOptions.length());
                char randomChar = passwordOptions.charAt(randomInt);

                if (i == 0 || i == passwordLength - 1 && isSimbols() && textSimbols.contains(String.valueOf(randomChar))) {
                    while (textSimbols.contains(String.valueOf(randomChar))) {
                        randomInt = secureRandom.nextInt(passwordOptions.length());
                        randomChar = passwordOptions.charAt(randomInt);
                    }
                }
                sb.append(randomChar);
            }

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algoritmo SecureRandom não encontrado: " + e.getMessage());
        }

        return sb.toString();
    }


}
