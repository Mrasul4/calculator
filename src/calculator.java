import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите математическую операцию:");
            String input = scanner.nextLine();

            try {
                System.out.println(calc(input));
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат математической операции");
        }

        String operand1 = parts[0];
        String operator = parts[1];
        String operand2 = parts[2];

        boolean isRoman1 = isRoman(operand1);
        boolean isRoman2 = isRoman(operand2);

        if (isRoman1 && isRoman2) {
            int num1 = romanToArabic(operand1);
            int num2 = romanToArabic(operand2);
            int result = calculate(num1, num2, operator);

            if (result <= 0) {
                throw new Exception("Результат римской операции не может быть нулём или отрицательным");
            }

            return arabicToRoman(result);
        } else if (!isRoman1 && !isRoman2) {
            int num1 = parseArabic(operand1);
            int num2 = parseArabic(operand2);

            if (num1 < 1 || num1 > 10 ||num2 < 1 || num2 > 10) {
                throw new Exception("Числа должны быть от 1 до 10");
            }

            return String.valueOf(calculate(num1, num2, operator));
        } else {
            throw new Exception("Используются разные системы счисления");
        }
    }

    private static int calculate(int num1, int num2, String operator) throws Exception {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) throw new Exception("Деление на ноль запрещено");
                yield num1 / num2;
            }
            default -> throw new Exception("Неизвестная операция: " + operator);
        };
    }

    private static boolean isRoman(String str) {
        return str.matches("I|II|III|IV|V|VI|VII|VIII|IX|X");
    }

    private static int romanToArabic(String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Некорректное римское число: " + roman);
        };
    }

    private static String arabicToRoman(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Результат римской операции не может быть меньше 1");
        }

        int[] arabicValues = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabicValues.length; i++) {
            while (number >= arabicValues[i]) {
                result.append(romanNumerals[i]);
                number -= arabicValues[i];
            }
        }
        return result.toString();
    }

    private static int parseArabic(String num) throws Exception {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new Exception("Некорректное арабское число: " + num);
        }
    }
}