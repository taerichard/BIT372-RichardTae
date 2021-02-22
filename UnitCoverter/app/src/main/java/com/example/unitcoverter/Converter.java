package com.example.unitcoverter;

public class Converter {
    public static double toCelcius(double fah) {
        return (fah - 32) * 5/9;
    }
    public static double toKilograms(double pounds){ return pounds * (float) 0.45359237; }
    public static double toFeet(double inches){ return inches/12; }
    public static double toMl(double ounces) { return ounces * (float) 29.57353; }
}
