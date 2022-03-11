package com.packages.bitcalculator;

public class ConvertDecimalInput {

    int fractionPrecision = 64;
    int decimalPrecision = 32;

    ConvertDecimalInput() {
    }

    String ConvertToBNR(String d) {
        String result;
        int decimalPart;
        int fractionPart;
        StringBuilder fractionBinaryString = new StringBuilder();
        StringBuilder decimalBinaryString = new StringBuilder();
        String decimalBinary;
        String fractionBinary;
        int sizeExtension;


        if (!d.contains(".")) {
            // Input Format : "xyz"
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
            String input = d.substring(0, d.indexOf('.'));
            if (d.indexOf('.') + 1 == d.length()) {
                // Input Format : "xyz."
                decimalPart = Integer.parseInt(input);
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
                // Input Format : "xyz.abc"

                decimalPart = Integer.parseInt(input);
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
        return result;
    }


    String ConvertToTRN(String d) {
        String result;
        int decimalPart;
        int fractionPart;
        StringBuilder fractionTernaryString = new StringBuilder();
        StringBuilder decimalTernaryString = new StringBuilder();
        StringBuilder decimalTernary = new StringBuilder();
        StringBuilder fractionTernary = new StringBuilder();
        int sizeExtension;


        if (!d.contains(".")) {
            // Input Format : "xyz"
            decimalPart = Integer.parseInt(d);
            fractionPart = 0;
            int digit = 0;
            while (decimalPart != 0) {
                digit = decimalPart % 3;
                decimalTernary.append(digit);
                decimalPart /= 3;
            }
            decimalTernary.reverse();

            fractionTernary.append(Integer.toBinaryString(fractionPart));

            sizeExtension = decimalPrecision - decimalTernary.length();
            for (int i = 1; i < sizeExtension; i++) {
                decimalTernaryString.append("0");
            }
            decimalTernaryString.append(decimalTernary);

            sizeExtension = fractionPrecision - fractionTernary.length();
            for (int i = 1; i < sizeExtension; i++) {
                fractionTernaryString.append("0");
            }
            fractionTernaryString.append(fractionTernary);

        } else {
            String input = d.substring(0, d.indexOf('.'));
            if (d.indexOf('.') + 1 == d.length()) {
                // Input Format : "xyz."
                decimalPart = Integer.parseInt(input);
                fractionPart = 0;

                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 3;
                    decimalTernary.append(digit);
                    decimalPart /= 3;
                }
                decimalTernary.reverse();

                fractionTernary.append(Integer.toBinaryString(fractionPart));

                sizeExtension = decimalPrecision - decimalTernary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalTernaryString.append("0");
                }
                decimalTernaryString.append(decimalTernary);

                sizeExtension = fractionPrecision - fractionTernary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    fractionTernaryString.append("0");
                }
                fractionTernaryString.append(fractionTernary);

            } else {
                // Input Format : "xyz.abc"

                decimalPart = Integer.parseInt(input);
                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 3;
                    decimalTernary.append(digit);
                    decimalPart /= 3;
                }
                decimalTernary.reverse();

                sizeExtension = decimalPrecision - decimalTernary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalTernaryString.append("0");
                }
                decimalTernaryString.append(decimalTernary);

                Double fraction = Double.parseDouble("0." + d.substring(d.indexOf('.') + 1));
                for (int i = 1; i < fractionPrecision; i++) {
                    fraction = fraction * 3;
                    int switchCase = (int)Math.floor(fraction);
                    switch (switchCase) {
                        case 0: {
                            fractionTernaryString.append("0");
                            break;
                        }
                        case 1: {
                            fractionTernaryString.append("1");
                            fraction = fraction - 1.0;
                            break;
                        }
                        case 2: {
                            fractionTernaryString.append("2");
                            fraction = fraction - 2.0;
                            break;
                        }
                    }
                }
            }
        }
        result = decimalTernaryString + "." + fractionTernaryString;
        return result;
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
