package com.protonn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class ProtonnUtils {
    /*
        This method converts a string to binary
     */
    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))
                            .replaceAll(" ", "0")
            );
        }
        return result.toString();
    }

    /*
        This method converts binary to string
     */
    public static String convertBinaryToString(String input) {
        int charCode = Integer.parseInt(input, 2);
        return Character.toString((char) charCode);
    }

    /*
        This method converts integer to binary
     */
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

        return binStr.toString();
    }

    /*
          this method converts binary to decimal
     */
    public static int binaryToDecimal(String n)
    {
        int dec_value = 0;

        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;

        int len = n.length();
        for (int i = len - 1; i >= 0; i--) {
            if (n.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }

    public static String getStringFromBIS(ByteArrayOutputStream bos) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = bis.read()) != -1) {
            sb.append((char) c);
        }
        String res = sb.toString();
        return res;
    }
}
