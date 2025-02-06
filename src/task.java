import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a > b) {
            System.out.println(" Первое число больше ");
        } else if (a < b) {
            System.out.println(" Второе число больше ");
        } else {
            System.out.println(" Числа равны ");
        }
    }
}
//Необходимо написать метод, который принимает два числа в качестве аргументов
//и возвращает строку с информацией о том, какое число больше - первое, второе или они равны.
//Затем в main считать из консоли два числа от пользователя
//и вызвать метод с этими значениями и вывести результат в консоль.