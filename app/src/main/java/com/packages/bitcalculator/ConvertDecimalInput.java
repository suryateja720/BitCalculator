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
        String result;
        int decimalPart;
        int fractionPart;
        StringBuilder fractionQuaternaryString = new StringBuilder();
        StringBuilder decimalQuaternaryString = new StringBuilder();
        StringBuilder decimalQuaternary = new StringBuilder();
        StringBuilder fractionQuaternary = new StringBuilder();
        int sizeExtension;


        if (!d.contains(".")) {
            // Input Format : "xyz"
            decimalPart = Integer.parseInt(d);
            fractionPart = 0;
            int digit = 0;
            while (decimalPart != 0) {
                digit = decimalPart % 4;
                decimalQuaternary.append(digit);
                decimalPart /= 4;
            }
            decimalQuaternary.reverse();

            fractionQuaternary.append(Integer.toBinaryString(fractionPart));

            sizeExtension = decimalPrecision - decimalQuaternary.length();
            for (int i = 1; i < sizeExtension; i++) {
                decimalQuaternaryString.append("0");
            }
            decimalQuaternaryString.append(decimalQuaternary);

            sizeExtension = fractionPrecision - fractionQuaternary.length();
            for (int i = 1; i < sizeExtension; i++) {
                fractionQuaternaryString.append("0");
            }
            fractionQuaternaryString.append(fractionQuaternary);

        } else {
            String input = d.substring(0, d.indexOf('.'));
            if (d.indexOf('.') + 1 == d.length()) {
                // Input Format : "xyz."
                decimalPart = Integer.parseInt(input);
                fractionPart = 0;

                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 4;
                    decimalQuaternary.append(digit);
                    decimalPart /= 4;
                }
                decimalQuaternary.reverse();

                fractionQuaternary.append(Integer.toBinaryString(fractionPart));

                sizeExtension = decimalPrecision - decimalQuaternary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalQuaternaryString.append("0");
                }
                decimalQuaternaryString.append(decimalQuaternary);

                sizeExtension = fractionPrecision - fractionQuaternary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    fractionQuaternaryString.append("0");
                }
                fractionQuaternaryString.append(fractionQuaternary);

            } else {
                // Input Format : "xyz.abc"

                decimalPart = Integer.parseInt(input);
                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 4;
                    decimalQuaternary.append(digit);
                    decimalPart /= 4;
                }
                decimalQuaternary.reverse();

                sizeExtension = decimalPrecision - decimalQuaternary.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalQuaternaryString.append("0");
                }
                decimalQuaternaryString.append(decimalQuaternary);

                Double fraction = Double.parseDouble("0." + d.substring(d.indexOf('.') + 1));
                for (int i = 1; i < fractionPrecision; i++) {
                    fraction = fraction * 4;
                    int switchCase = (int)Math.floor(fraction);
                    switch (switchCase) {
                        case 0: {
                            fractionQuaternaryString.append("0");
                            break;
                        }
                        case 1: {
                            fractionQuaternaryString.append("1");
                            fraction = fraction - 1.0;
                            break;
                        }
                        case 2: {
                            fractionQuaternaryString.append("2");
                            fraction = fraction - 2.0;
                            break;
                        }
                        case 3: {
                            fractionQuaternaryString.append("3");
                            fraction = fraction - 3.0;
                            break;
                        }
                    }
                }
            }
        }
        result = decimalQuaternaryString + "." + fractionQuaternaryString;
        return result;
    }

    String ConvertToOCT(String d) {
        String result;
        int decimalPart;
        int fractionPart;
        StringBuilder fractionOctalString = new StringBuilder();
        StringBuilder decimalOctalString = new StringBuilder();
        StringBuilder decimalOctal = new StringBuilder();
        StringBuilder fractionOctal = new StringBuilder();
        int sizeExtension;


        if (!d.contains(".")) {
            // Input Format : "xyz"
            decimalPart = Integer.parseInt(d);
            fractionPart = 0;
            int digit = 0;
            while (decimalPart != 0) {
                digit = decimalPart % 8;
                decimalOctal.append(digit);
                decimalPart /= 8;
            }
            decimalOctal.reverse();

            fractionOctal.append(Integer.toBinaryString(fractionPart));

            sizeExtension = decimalPrecision - decimalOctal.length();
            for (int i = 1; i < sizeExtension; i++) {
                decimalOctalString.append("0");
            }
            decimalOctalString.append(decimalOctal);

            sizeExtension = fractionPrecision - fractionOctal.length();
            for (int i = 1; i < sizeExtension; i++) {
                fractionOctalString.append("0");
            }
            fractionOctalString.append(fractionOctal);

        } else {
            String input = d.substring(0, d.indexOf('.'));
            if (d.indexOf('.') + 1 == d.length()) {
                // Input Format : "xyz."
                decimalPart = Integer.parseInt(input);
                fractionPart = 0;

                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 8;
                    decimalOctal.append(digit);
                    decimalPart /= 8;
                }
                decimalOctal.reverse();

                fractionOctal.append(Integer.toBinaryString(fractionPart));

                sizeExtension = decimalPrecision - decimalOctal.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalOctalString.append("0");
                }
                decimalOctalString.append(decimalOctal);

                sizeExtension = fractionPrecision - fractionOctal.length();
                for (int i = 1; i < sizeExtension; i++) {
                    fractionOctalString.append("0");
                }
                fractionOctalString.append(fractionOctal);

            } else {
                // Input Format : "xyz.abc"

                decimalPart = Integer.parseInt(input);
                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 8;
                    decimalOctal.append(digit);
                    decimalPart /= 8;
                }
                decimalOctal.reverse();

                sizeExtension = decimalPrecision - decimalOctal.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalOctalString.append("0");
                }
                decimalOctalString.append(decimalOctal);

                double fraction = Double.parseDouble("0." + d.substring(d.indexOf('.') + 1));
                for (int i = 1; i < fractionPrecision; i++) {
                    fraction = fraction * 8;
                    int switchCase = (int)Math.floor(fraction);
                    switch (switchCase) {
                        case 0: {
                            fractionOctalString.append("0");
                            break;
                        }
                        case 1: {
                            fractionOctalString.append("1");
                            fraction = fraction - 1.0;
                            break;
                        }
                        case 2: {
                            fractionOctalString.append("2");
                            fraction = fraction - 2.0;
                            break;
                        }
                        case 3: {
                            fractionOctalString.append("3");
                            fraction = fraction - 3.0;
                            break;
                        }
                        case 4: {
                            fractionOctalString.append("4");
                            fraction = fraction - 4.0;
                            break;
                        }
                        case 5: {
                            fractionOctalString.append("5");
                            fraction = fraction - 5.0;
                            break;
                        }
                        case 6: {
                            fractionOctalString.append("6");
                            fraction = fraction - 6.0;
                            break;
                        }
                        case 7: {
                            fractionOctalString.append("7");
                            fraction = fraction - 7.0;
                            break;
                        }
                    }
                }
            }
        }
        result = decimalOctalString + "." + fractionOctalString;
        return result;
    }

    String ConvertToHEX(String d) {
        String result;
        int decimalPart;
        int fractionPart;
        StringBuilder fractionHexString = new StringBuilder();
        StringBuilder decimalHexString = new StringBuilder();
        StringBuilder decimalHex = new StringBuilder();
        StringBuilder fractionHex = new StringBuilder();
        int sizeExtension;


        if (!d.contains(".")) {
            // Input Format : "xyz"
            decimalPart = Integer.parseInt(d);
            fractionPart = 0;
            int digit = 0;
            while (decimalPart != 0) {
                digit = decimalPart % 16;
                if(digit<10)decimalHex.append(digit);
                else switch (digit){
                    case 10 : decimalHex.append("A");break;
                    case 11 : decimalHex.append("B");break;
                    case 12 : decimalHex.append("C");break;
                    case 13 : decimalHex.append("D");break;
                    case 14 : decimalHex.append("E");break;
                    case 15 : decimalHex.append("F");break;
                }
                decimalPart /= 16;
            }
            decimalHex.reverse();

            fractionHex.append(Integer.toBinaryString(fractionPart));

            sizeExtension = decimalPrecision - decimalHex.length();
            for (int i = 1; i < sizeExtension; i++) {
                decimalHexString.append("0");
            }
            decimalHexString.append(decimalHex);

            sizeExtension = fractionPrecision - fractionHex.length();
            for (int i = 1; i < sizeExtension; i++) {
                fractionHexString.append("0");
            }
            fractionHexString.append(fractionHex);

        } else {
            String input = d.substring(0, d.indexOf('.'));
            if (d.indexOf('.') + 1 == d.length()) {
                // Input Format : "xyz."
                decimalPart = Integer.parseInt(input);
                fractionPart = 0;

                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 16;
                    if(digit<10)decimalHex.append(digit);
                    else switch (digit){
                        case 10 : decimalHex.append("A");break;
                        case 11 : decimalHex.append("B");break;
                        case 12 : decimalHex.append("C");break;
                        case 13 : decimalHex.append("D");break;
                        case 14 : decimalHex.append("E");break;
                        case 15 : decimalHex.append("F");break;
                    }
                    decimalPart /= 16;
                }
                decimalHex.reverse();

                fractionHex.append(Integer.toBinaryString(fractionPart));

                sizeExtension = decimalPrecision - decimalHex.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalHexString.append("0");
                }
                decimalHexString.append(decimalHex);

                sizeExtension = fractionPrecision - fractionHex.length();
                for (int i = 1; i < sizeExtension; i++) {
                    fractionHexString.append("0");
                }
                fractionHexString.append(fractionHex);

            } else {
                // Input Format : "xyz.abc"

                decimalPart = Integer.parseInt(input);
                int digit = 0;
                while (decimalPart != 0) {
                    digit = decimalPart % 16;
                    if(digit<10)decimalHex.append(digit);
                    else switch (digit){
                        case 10 : decimalHex.append("A");break;
                        case 11 : decimalHex.append("B");break;
                        case 12 : decimalHex.append("C");break;
                        case 13 : decimalHex.append("D");break;
                        case 14 : decimalHex.append("E");break;
                        case 15 : decimalHex.append("F");break;
                    }
                    decimalPart /= 16;
                }
                decimalHex.reverse();

                sizeExtension = decimalPrecision - decimalHex.length();
                for (int i = 1; i < sizeExtension; i++) {
                    decimalHexString.append("0");
                }
                decimalHexString.append(decimalHex);

                double fraction = Double.parseDouble("0." + d.substring(d.indexOf('.') + 1));
                for (int i = 1; i < fractionPrecision; i++) {
                    fraction = fraction * 16;
                    int switchCase = (int)Math.floor(fraction);
                    switch (switchCase) {
                        case 0: {
                            fractionHexString.append("0");
                            break;
                        }
                        case 1: {
                            fractionHexString.append("1");
                            fraction = fraction - 1.0;
                            break;
                        }
                        case 2: {
                            fractionHexString.append("2");
                            fraction = fraction - 2.0;
                            break;
                        }
                        case 3: {
                            fractionHexString.append("3");
                            fraction = fraction - 3.0;
                            break;
                        }
                        case 4: {
                            fractionHexString.append("4");
                            fraction = fraction - 4.0;
                            break;
                        }
                        case 5: {
                            fractionHexString.append("5");
                            fraction = fraction - 5.0;
                            break;
                        }
                        case 6: {
                            fractionHexString.append("6");
                            fraction = fraction - 6.0;
                            break;
                        }
                        case 7: {
                            fractionHexString.append("7");
                            fraction = fraction - 7.0;
                            break;
                        }
                        case 8: {
                            fractionHexString.append("8");
                            fraction = fraction - 8.0;
                            break;
                        }
                        case 9: {
                            fractionHexString.append("9");
                            fraction = fraction - 9.0;
                            break;
                        }
                        case 10: {
                            fractionHexString.append("A");
                            fraction = fraction - 10.0;
                            break;
                        }
                        case 11: {
                            fractionHexString.append("B");
                            fraction = fraction - 11.0;
                            break;
                        }
                        case 12: {
                            fractionHexString.append("C");
                            fraction = fraction - 12.0;
                            break;
                        }
                        case 13: {
                            fractionHexString.append("D");
                            fraction = fraction - 13.0;
                            break;
                        }
                        case 14: {
                            fractionHexString.append("E");
                            fraction = fraction - 14.0;
                            break;
                        }
                        case 15: {
                            fractionHexString.append("F");
                            fraction = fraction - 15.0;
                            break;
                        }
                    }
                }
            }
        }
        result = decimalHexString + "." + fractionHexString;
        return result;
    }


}
