package org.example.service;

import java.util.regex.*;

public class Validation {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidWebsite(String website) {
        String websiteRegex = "^(http://|https://)?(www\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(/\\S*)?$";
        Pattern pattern = Pattern.compile(website);
        Matcher matcher = pattern.matcher(websiteRegex);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(passwordRegex);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(int phoneNumber) {
        String phoneNumberRegex = "^09\\d{9}$";
        Pattern pattern = Pattern.compile(String.valueOf(phoneNumber));
        Matcher matcher = pattern.matcher(phoneNumberRegex);
        return matcher.matches();
    }

    public static boolean isValidNationalCode(int nationalCode) {
        String nationalCodeRegex = "\\d{10}";
        Pattern pattern = Pattern.compile(String.valueOf(nationalCode));
        Matcher matcher = pattern.matcher(nationalCodeRegex);
        return matcher.matches();
    }

}
