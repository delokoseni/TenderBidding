package com.example.TenderBidding.validators;

public class InnValidator {
    private static final int MIN_INN_LENGTH = 10;
    private static final int MAX_INN_LENGTH = 12;

    public static boolean isValidInn(String inn) {
        if (inn == null || inn.length() < MIN_INN_LENGTH || inn.length() > MAX_INN_LENGTH) {
            return false; // Не соответствует длине
        }
        return inn.matches("\\d+"); // Проверка, что все символы — цифры
    }

    public static int getMinInnLength() {
        return MIN_INN_LENGTH;
    }
    public static int getMaxInnLength() {
        return MAX_INN_LENGTH;
    }
}
