package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }

    public static double poundToKg(double pound){
        return pound * 0.45359237;
    }

    public static double inchesToFeet(double inches){ return inches/12;}

    public static double ouncesToMl(double ounces){ return ounces * 29.57353;}

}
