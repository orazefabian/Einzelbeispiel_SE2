package com.example.einzelbeispiel;

public class Calculator {


    public static String calculate_Common_factors(String matrikelnummer) {
        String output = "";
        int[] values = get_IntArr_From_CharArr(matrikelnummer);

        for (int i = 0; i < values.length - 1; i++) {
            int num1 = values[i];
            if (num1 > 1) {
                for (int i2 = i + 1; i2 < values.length; i2++) {
                    int num2 = values[i2];
                    if (num2 > 1) {
                        for (int j = 2; j < 10; j++) {
                            if (num1 % j == 0 && num2 % j == 0) {
                                output = "Index [" + i + "] und Index [" + i2 + "] haben denselben Teiler!";
                            }
                        }
                    }
                }
            }
            if (output == "") {
                output = "Es gibt keine Zahlen mit gleichem Teiler!";
            }
        }
        return output;

    }

    private static int[] get_IntArr_From_CharArr(String matrikelnummer) {
        char[] charArr = matrikelnummer.toCharArray();
        int[] values = new int[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            values[i] = Integer.parseInt(String.valueOf(charArr[i]));
        }
        return values;
    }
}
