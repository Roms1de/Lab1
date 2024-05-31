package Lab1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;


//  8.Дан текстовый файл с программой на алгоритмическом языке.
//  За один просмотр файла проверить баланс квадратных скобок в тексте, используя дек.
public class Lab1 {
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        int minAscii = 90; // Начальный символ таблицы ASCII
        int maxAscii = 100; // Конечный символ таблицы ASCII

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(maxAscii - minAscii + 1) + minAscii);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String randomStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину строки: ");
        int strlength = in.nextInt();
        String string = generateRandomString(strlength);
        System.out.println("______Строка успешно создана______");
        System.out.println(string);
        System.out.println();
        return string;
    }


    public static void main(String[] args) {
        String strings = randomStr();
//        String strings = "34[435[465]567[456]756]657][";
        char searchCharOne = '[';
        char searchCharTwo = ']';
        Deque<Character> chars = new ArrayDeque<>();


        for (int i = 0; i < strings.length(); i++) {
            if (strings.charAt(i) == searchCharOne) {
                chars.addFirst(strings.charAt(i));
            } else if (strings.charAt(i) == searchCharTwo) {
                chars.addLast(strings.charAt(i));
            }
        }
        System.out.println(chars);


        while (chars.getFirst() == searchCharOne && chars.getLast() == searchCharTwo) {
            chars.pollFirst();
            chars.pollLast();
            if (chars.isEmpty()) {
                System.out.println(chars);
                System.out.println("Баланс скобок соблюден");
                break;
            }
        }
        if (!chars.isEmpty()) {
            System.out.println(chars);
            System.out.println("Баланс скобок нарушен");
        }
    }
}


//открыть файл, считать строку, проверять последовательно символы [] добавлять в дек, далее из дека удалять с двух сторон
//если дек не станет пустым, баланс отсутствует