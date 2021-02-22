package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }
    public static float toKilograms(float pounds){ return pounds * (float) 0.45359237; }
    public static float toFeet(float inches){ return inches/12; }
    public static float toMl(float ounces) { return ounces * (float) 29.57353; }
}
