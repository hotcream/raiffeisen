package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en-US"));
    public String searchAddress = getAddress();

    public String getAddress() {
        return "Москва";
    }
}