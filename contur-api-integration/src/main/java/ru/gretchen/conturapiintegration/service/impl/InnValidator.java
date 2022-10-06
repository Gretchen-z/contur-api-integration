package ru.gretchen.conturapiintegration.service.impl;

public class InnValidator {
    public static boolean isValid(String inn) {
        String innRegex = "\\d{10}|\\d{12}";
        return inn.matches(innRegex);
    }
}
