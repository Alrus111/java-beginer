import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение через пробел");
        String input = scanner.nextLine();

        var result = calc(input);
        System.out.println("Результат операции: " + result);
    }

    static  boolean requirementsVerificationDecimal(String[] decomposeInput) throws Exception {
        var char1 = decomposeInput[0].toCharArray()[0];
        var char2 = decomposeInput[2].toCharArray()[0];
        if (Character.isDigit(char1) && Character.isDigit(char2)){
            var num1 = Integer.parseInt(decomposeInput[0]);
            var num2 = Integer.parseInt(decomposeInput[2]);

            if(decomposeInput.length>3) {
                throw new Exception("Калькулятор может работать только с двумя числами");
            }
            else if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10){
                return  true;
            }
            else {
                throw new Exception("Оба числа должны быть от 1 до 10");
            }
        }else {
            return false;
        }
    }
    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[numArabian];
        return s;
    }

    static boolean requirementsVerificationRome(String[] decomposeInput) throws Exception {
        String[] romeNumber = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        if(decomposeInput.length>3) {
            throw new Exception("Калькулятор может работать только с двумя числами");
        }
        else if (Arrays.asList(romeNumber).contains(decomposeInput[0])&&
                Arrays.asList(romeNumber).contains(decomposeInput[2])){
            return  true;
        }
        else {
            throw new Exception("Оба числа должны быть римскими");
        }
    }

    static String calc (String input) throws Exception{
        String[] decomposeInput = input.split(" ");
        int result;
        int num1;
        int num2;
        if (requirementsVerificationDecimal(decomposeInput)) {
            num1 = Integer.parseInt(decomposeInput[0]);
            num2 = Integer.parseInt(decomposeInput[2]);
        }
        else if (requirementsVerificationRome(decomposeInput)) {
            String[] romeNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            num1 = Arrays.asList(romeNumber).indexOf(decomposeInput[0]) + 1;
            num2 = Arrays.asList(romeNumber).indexOf(decomposeInput[2]) + 1;
        } else {
            throw new Exception("Калькулятор работает только с римскими или арабскими числами");
        }
        var operation = decomposeInput[1].toCharArray()[0];
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                throw new Exception("Операция не распознана");
            }
        }
        if (requirementsVerificationDecimal(decomposeInput))
            return String.valueOf(result);
        else {
            if (result <= 0)
                throw new Exception("Римские числа не могут быть отрицательными или равными нулю");
            else
                return convertNumToRoman(result);
        }
    }
}