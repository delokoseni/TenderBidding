package com.example.TenderBidding.validators;

public class OrganizationNameValidator {

    private static final int MAX_NAME_LENGTH = 100;
    private static final String NAME_REGEX = "^[А-Яа-я0-9,.\\s-()']+$";

    /**
     * Метод для проверки длины наименования организации
     *
     * @param name наименование организации для проверки
     * @return true, если длина допустима, иначе false
     */
    public static boolean isValidLength(String name) {
        return name != null && name.length() <= MAX_NAME_LENGTH;
    }

    /**
     * Метод для проверки формата наименования организации
     *
     * @param name наименование организации для проверки
     * @return true, если формат верный, иначе false
     */
    public static boolean isValidFormat(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public static int getMaxNameLength() {
        return MAX_NAME_LENGTH;
    }
}
