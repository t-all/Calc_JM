package com.company;

import java.util.Scanner;
import static java.lang.String.join;
import static java.util.Collections.nCopies;

public class Main {
    public static Integer num1, num2, result;
    public static String operation;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[]myarray = input.split(" ");
        sc.close();
        //System.out.println(myarray.length);

        if (isDigit(myarray[0]) && isDigit(myarray[2])) {
            num1 = Integer.valueOf(myarray[0]);
            num2 = Integer.valueOf(myarray[2]);
            operation = myarray[1];

            if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10 || myarray.length>3) {
                throw new IllegalArgumentException();
            }
            result = Calc();
            System.out.println(result);
        }else if(isDigit(myarray[0]) != isDigit(myarray[2])){
            throw new IllegalArgumentException();
        }
        else {
            num1 = RomeToInt(myarray[0]);
            num2 = RomeToInt(myarray[2]);
            operation = myarray[1];
            result = Calc();
            System.out.println(IntToRome(result));
        }
    }

    public static Integer Calc() {
        switch (operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "/": result = num1 / num2; break;
            case "*": result = num1 * num2; break;
            default: throw new IllegalArgumentException();
        }
        return result;

    }


    public static boolean isDigit (String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static String IntToRome(int num) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] letters = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String rome = "";
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            while (num >= numbers[i]) {
                rome += letters[i];
                num -= numbers[i];
            }

            for (int j = 0; j < rome.length(); j ++){
                count ++;
            }System.out.println(count);

            if (count == 0) {
                throw new IllegalArgumentException();
            }

            return join("", nCopies(count, "I"))
                    .replace ("IIIII", "V")
                    .replace ("IIII", "IV")
                    .replace("VV", "X")
                    .replace("VIV","IX")
                    .replace("XXXXX","L")
                    .replace("XXXX","XL")
                    .replace("LL", "C");
        }
        return rome;
    }

    public static int RomeToInt(String letter) {
        int num = 0;
        switch (letter) {
            case "I": num = 1; break;
            case "II": num = 2; break;
            case "III": num = 3; break;
            case "IV": num = 4; break;
            case "V": num = 5; break;
            case "VI": num = 6; break;
            case "VII": num = 7; break;
            case "VIII": num = 8; break;
            case "IX": num = 9; break;
            case "X": num = 10; break;
        }
        return num;
    }
}