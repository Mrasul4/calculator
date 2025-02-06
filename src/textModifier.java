import java.util.Scanner;

public class textModifier {
    public static void main(String[] args) {
        System.out.println(text_Modifier());
    }

    public static String text_Modifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String input = scanner.nextLine();
        StringBuilder step1 = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ' && (i == 0 || input.charAt(i - 1) == ' ')) {
                continue;
            }
            step1.append(c);
        }
        StringBuilder step2 = new StringBuilder();
        for (int i = 0; i < step1.length(); i++) {
            char c = step1.charAt(i);
            if (c == '-' && i > 0 && i < step1.length() - 1) {
                step2.setCharAt(step2.length() - 1, step1.charAt(i + 1));
                step2.append(step1.charAt(i - 1));
                i++;
            } else if (c != '-') {
                step2.append(c);
            }
        }
        StringBuilder step3 = new StringBuilder();
        for (int i = 0; i < step2.length(); i++) {
            char c = step2.charAt(i);
            if (c == '+') {
                step3.append('!');
            } else {
                step3.append(c);
            }
        }
        StringBuilder result = new StringBuilder();
        int digitSum = 0;
        for (int i = 0; i < step3.length(); i++) {
            char c = step3.charAt(i);
            if (Character.isDigit(c)) {
                digitSum += Character.getNumericValue(c);
            } else {
                result.append(c);
            }
        }
        if (digitSum > 0) {
            result.append(" ").append(digitSum);
        }

        return result.toString();
    }
}
