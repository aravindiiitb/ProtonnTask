package com.protonn;

public class ProtonnUtils {
    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();
    }

    public static String convertBinaryToString(String input) {
        int charCode = Integer.parseInt(input, 2);
        return Character.toString((char) charCode);
    }

    public static String convertIntegerToBinary(Integer input) {
        StringBuilder binStr = new StringBuilder();
        while(input > 0) {
            int a = input % 2;
            binStr.insert(0, a);
            input = input / 2;
        }

        while (binStr.length() < 8) {
            binStr.insert(0, "0");
        }

        System.out.println(binStr.toString());
        return binStr.toString();
    }

    public static int binaryToDecimal(String n)
    {
        String num = n;
        int dec_value = 0;

        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }
}
