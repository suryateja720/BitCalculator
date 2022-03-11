package com.packages.bitcalculator;

public class ConvertDecimalInput {

    Integer fractionPrecision = 64;
    Integer decimalPrecision = 32;

    ConvertDecimalInput() {
    }

    String ConvertToBNR(String d) {
        String result = "";
        Double input = Double.parseDouble(d);

        Integer breakPoint = input.toString().indexOf('.');
        Integer fractionLength = input.toString().length() - breakPoint;

        Integer decimalPart;
        Integer fractionPart;


        StringBuilder fractionBinaryString = new StringBuilder();
        StringBuilder decimalBinaryString = new StringBuilder();
        String decimalBinary;
        String fractionBinary;
        Integer sizeExtension = 0;


        if (!d.contains(".")) {
            //xyz
            decimalPart = Integer.parseInt(d);
            fractionPart = 0;
            decimalBinary = Integer.toBinaryString(decimalPart);
            fractionBinary = Integer.toBinaryString(fractionPart);

            sizeExtension = decimalPrecision - decimalBinary.length();
            for (int i = 1; i < sizeExtension; i++) {
                decimalBinaryString.append("0");
            }
            decimalBinaryString.append(decimalBinary);

            sizeExtension = fractionPrecision - fractionBinary.length();
            for (int i = 1; i < sizeExtension; i++) {
                fractionBinaryString.append("0");
            }
            fractionBinaryString.append(fractionBinary);

        } else {

            if (d.indexOf('.') + 1 == d.length()) {
                //xyz.
                decimalPart = Integer.parseInt(d.substring(0, d.indexOf('.')));
                fractionPart = 0;

                decimalBinary = Integer.toBinaryString(decimalPart);
                fractionBinary = Integer.toBinaryString(fractionPart);

                sizeExtension = decimalPrecision - decimalBinary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalBinaryString.append("0");
                }
                decimalBinaryString.append(decimalBinary);

                sizeExtension = fractionPrecision - fractionBinary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    fractionBinaryString.append("0");
                }
                fractionBinaryString.append(fractionBinary);

            } else {
                //xyz.abc
                decimalPart = Integer.parseInt(d.substring(0, d.indexOf('.')));
                decimalBinary = Integer.toBinaryString(decimalPart);

                sizeExtension = decimalPrecision - decimalBinary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalBinaryString.append("0");
                }
                decimalBinaryString.append(decimalBinary);

                Double fraction = Double.parseDouble("0." + d.substring(d.indexOf('.') + 1));
                for (int i = 1; i < fractionPrecision; i++) {
                    fraction = fraction * 2;
                    if (fraction < 1.0) fractionBinaryString.append("0");
                    else {
                        fraction = fraction - 1.0;
                        fractionBinaryString.append("1");
                    }
                }
            }
        }
        result = decimalBinaryString + "." + fractionBinaryString;
        return result.toString();
    }

    String ConvertToTRN(String d) {
        String b = "";
        b = Integer.toBinaryString((int) Double.parseDouble(d));
        return b;
    }

    String ConvertToQDR(String d) {
        String b = "";
        b = Integer.toBinaryString((int) Double.parseDouble(d));
        return b;
    }

    String ConvertToOCT(String d) {
        String b = "";
        b = Integer.toBinaryString((int) Double.parseDouble(d));
        return b;
    }

    String ConvertToHEX(String d) {
        String b = "";
        b = Integer.toBinaryString((int) Double.parseDouble(d));
        return b;
    }


}
