package com.packages.bitcalculator;

public class ConvertBinaryInput {

    int fractionPrecision = 64;
    int decimalPrecision = 32;

    ConvertBinaryInput() {
    }

    String ConvertToDEC(String d) {
        String result;
        int decimalPart = 0;
        int fractionPart;
        StringBuilder fractionDecimalString = new StringBuilder();
        StringBuilder decimalDecimalString = new StringBuilder();
        String decimalDecimal;
        String fractionDecimal;
        int sizeExtension;


        int count = 1;
        int digit;


        if (!d.contains(".")) {
            // Input Format : "xyz"
            for (int i = 0; !d.isEmpty(); i++) {
                digit = Integer.parseInt(Character.toString(d.charAt(d.length()-1)));
                d = d.substring(0,d.length()-1);
                decimalPart = decimalPart + digit * count;
                count = count * 2;
            }
            fractionPart = 0;
            fractionDecimal = Integer.toBinaryString(fractionPart);

            sizeExtension = decimalPrecision - Integer.toString(decimalPart).length();
            for (int i = 1; i < sizeExtension; i++) {
                decimalDecimalString.append("0");
            }
            decimalDecimalString.append(decimalPart);

            sizeExtension = fractionPrecision - fractionDecimal.length();
            for (int i = 1; i < sizeExtension; i++) {
                fractionDecimalString.append("0");
            }
            fractionDecimalString.append(fractionDecimal);

        }
//        else {
//            String input = d.substring(0, d.indexOf('.'));
//            if (d.indexOf('.') + 1 == d.length()) {
//                // Input Format : "xyz."
//                decimalPart = Integer.parseInt(input);
//                fractionPart = 0;
//
//                decimalDecimal = Integer.toBinaryString(decimalPart);
//                fractionDecimal = Integer.toBinaryString(fractionPart);
//
//                sizeExtension = decimalPrecision - decimalDecimal.length();
//                for (int i = 1; i < sizeExtension; i++) {
//                    decimalDecimalString.append("0");
//                }
//                decimalDecimalString.append(decimalDecimal);
//
//                sizeExtension = fractionPrecision - fractionDecimal.length();
//                for (int i = 1; i < sizeExtension; i++) {
//                    fractionDecimalString.append("0");
//                }
//                fractionDecimalString.append(fractionDecimal);
//
//            } else {
//                // Input Format : "xyz.abc"
//
//                decimalPart = Integer.parseInt(input);
//                decimalDecimal = Integer.toBinaryString(decimalPart);
//
//                sizeExtension = decimalPrecision - decimalDecimal.length();
//                for (int i = 1; i < sizeExtension; i++) {
//                    decimalDecimalString.append("0");
//                }
//                decimalDecimalString.append(decimalDecimal);
//
//                double fraction = Double.parseDouble("0." + d.substring(d.indexOf('.') + 1));
//                for (int i = 1; i < fractionPrecision; i++) {
//                    fraction = fraction * 2;
//                    if (fraction < 1.0) fractionDecimalString.append("0");
//                    else {
//                        fraction = fraction - 1.0;
//                        fractionDecimalString.append("1");
//                    }
//                }
//            }
//        }
        result = decimalDecimalString + "." + fractionDecimalString;
        return result;
    }

    String ConvertToTRN(String d) {
        return d;
    }

    String ConvertToQDR(String d) {
        return d;
    }

    String ConvertToOCT(String d) {
        return d;
    }

    String ConvertToHEX(String d) {
        return d;
    }
}
