package com.pombalGustavo.Password_Generator.service;

import com.pombalGustavo.Password_Generator.exception.PasswordException;
import com.pombalGustavo.Password_Generator.model.PasswordOptions;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class PasswordGeneratorService {

    private static final String textSimbols = "\"!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~\"";
    private static final String textUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String textLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String textNumbers = "0123456789";

    public String validateOptions(PasswordOptions passwordOptions) {
        StringBuilder sb = new StringBuilder();

        if (passwordOptions.isSimbols()) {
            sb.append(textSimbols);
        }
        if (passwordOptions.isUpperCase()) {
            sb.append(textUpperCase);
        }
        if (passwordOptions.isLowerCase()) {
            sb.append(textLowerCase);
        }
        if (passwordOptions.isNumbers()) {
            sb.append(textNumbers);
        }

        if (sb.isEmpty()) {
            throw new PasswordException("Erro! Nenhuma opção para a senha foi escolhida");
        }

        return sb.toString();
    }

    public String generateRandomPassword(String validPasswordOptions, PasswordOptions passwordOptions) {

        StringBuilder sb = new StringBuilder();
        int passwordLength = passwordOptions.getPasswordLength();

        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

            for (int i = 0; i < passwordLength; i++) {
                int randomInt = secureRandom.nextInt(validPasswordOptions.length());
                char randomChar = validPasswordOptions.charAt(randomInt);

                if (i == 0 || i == passwordLength - 1 && passwordOptions.isSimbols() && textSimbols.contains(String.valueOf(randomChar))) {
                    while (textSimbols.contains(String.valueOf(randomChar))) {
                        randomInt = secureRandom.nextInt(validPasswordOptions.length());
                        randomChar = validPasswordOptions.charAt(randomInt);
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
