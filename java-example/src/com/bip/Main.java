package com.bip;

public class Main {
    public static void main(String[] args) {
        String ans = getValue("a");
        System.out.println(ans);
    }

    public static String getValue(String key) {
        return switch (key) {
            case "a" -> "Result 1";
            case "b" -> "Result 2";
            case "c" -> "Result 3";
            default -> "Default Result";
        };
    }
}