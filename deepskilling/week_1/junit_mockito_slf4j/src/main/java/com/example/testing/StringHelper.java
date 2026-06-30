package com.example.testing;

public class StringHelper {
    public String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public boolean isPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        return normalized.equals(reverse(normalized));
    }
}
