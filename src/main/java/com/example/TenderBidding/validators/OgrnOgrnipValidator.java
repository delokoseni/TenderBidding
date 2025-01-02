package com.example.TenderBidding.validators;

public class OgrnOgrnipValidator {
    private static final int MIN_OGRN_OGRNIP_LENGTH = 13;
    private static final int MAX_OGRN_OGRNIP_LENGTH = 15;

    public static boolean isValidOgrnOgrnip(String ogrnOgrnip) {
        if (ogrnOgrnip == null || ogrnOgrnip.length() < MIN_OGRN_OGRNIP_LENGTH || ogrnOgrnip.length() > MAX_OGRN_OGRNIP_LENGTH) {
            return false; // Не соответствует длине
        }
        return ogrnOgrnip.matches("\\d+"); // Проверка, что все символы — цифры
    }

    public static int getMinOgrnOgrnipLength() {
        return MIN_OGRN_OGRNIP_LENGTH;
    }
    public static int getMaxOgrnOgrnipLength() {
        return MAX_OGRN_OGRNIP_LENGTH;
    }
}
