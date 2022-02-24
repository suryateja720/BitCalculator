package com.packages.bitcalculator;

public class ConvertDecimalInput {

    ConvertDecimalInput() {
    }

    String ConvertToBNR(String d) {
        String integerBinary = "";
        String fractionBinary = "0";
        String[] decimal = {"0", "0"};
        int integerPart = 0;
        double fractionPart = 0.0;

        if (d.contains(".") && d.charAt(d.length() - 1) != '.') {
            decimal[0] = d.substring(0, d.indexOf("."));
            decimal[1] = d.substring(d.indexOf(".") + 1);
        } else if (d.contains(".")) {
            decimal[0] = d.substring(0, d.indexOf("."));
        } else {
            decimal[0] = d;
        }

        if (decimal[0].length() != 0) {
            integerPart = Integer.parseInt(decimal[0]);
        }

        if (decimal[1].length() != 0 && d.contains(".")) {
            fractionPart = Integer.parseInt(decimal[1]) / Math.pow(10, decimal[1].length());
        } else {
            fractionPart = 0.0;
        }
        int limit = 0;
        StringBuilder iBuilder = new StringBuilder();

        while (integerPart != 1) {
            limit++;
            iBuilder.append(integerPart % 2);
            integerPart = integerPart / 2;
        }
        iBuilder.append("1");
        iBuilder.reverse();
        integerBinary = iBuilder.toString();


        int f;
        limit = 0;
        StringBuilder fBuilder = new StringBuilder();

        while (fractionPart != 0.0 && limit < 10) {

            f = (int) (fractionPart * 2);
            fBuilder.append(f);
            fractionPart = (fractionPart * 2) - (int)(fractionPart * 2);
            limit++;
        }

        fractionBinary = fBuilder.toString();

        if(d.contains(".")){
            return integerBinary + "." + fractionBinary;
        }else{
            return integerBinary ;
        }
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
