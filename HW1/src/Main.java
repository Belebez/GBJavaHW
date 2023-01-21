import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.print("Приветствую! Можете выбрать 1 из 5 задач.\n" +
                "1. Вычесляет сумму чисел от 1 до n.\n" +
                "2. Вычисляет n!(произведение чисел от 1 до n).\n" +
                "3. Выводит все простые числа от 1 до 1000.\n" +
                "4. Простой кулькулятор.\n" +
                "5. Решает уравнение с неизвестными. Пример 2? + ?5 = 69\n");
        System.out.print("Введите номер задачи --> ");
        Scanner aScanner = new Scanner(System.in);
        int taskNum = aScanner.nextInt();

        switch (taskNum) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            default:
                System.out.println("\nТакого задания нет.");
                break;
        }
    }

    public static void task1() {
        /*
        Вычислить n-ое треугольного число(сумма чисел от 1 до n)
         */
        System.out.print("\nВведите n --> ");
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();

        int sumNum = 0;
        for (int i = 1; i < num + 1; i++) {
            sumNum += i;
        }
        System.out.printf("Сумма чисел от 1 до %d, равна - %d", num, sumNum);
    }

    public static void task2() {
        /*
        Вычислить n! (произведение чисел от 1 до n)
         */
        System.out.print("\nВведите n --> ");
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();

        int factorialNum = 1;
        for (int i = 1; i < num + 1; i++) {
            factorialNum *= i;
        }
        System.out.printf("Факториал числа %d, равен - %d", num, factorialNum);
    }

    public static void task3() {
        /*
        Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только на себя и на единицу
        без остатка. Чтобы найти остаток от деления используйте оператор % , например 10%3 будет равно единице)
         */
        System.out.println();
        for (int i = 2; i < 1001; i++) {
            boolean simpleNum = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simpleNum = false;
                    break;
                }
            }
            if (simpleNum) {
                System.out.print(i + " ");
            }
        }
    }

    public static void task4() {
        /*
        Реализовать простой калькулятор ("введите первое число"... "Введите второе число"... "укажите операцию,
        которую надо выполнить с этими числами"... "ответ: ...")
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите первое число --> ");
        Integer num1 = scanner.nextInt();
        System.out.print("Введите операцию, которую нужно выполнить(+,-,*,/,**) --> ");
        Scanner iScanner = new Scanner(System.in);
        String operation = iScanner.nextLine();
        System.out.print("Введите второе число --> ");
        Integer num2 = scanner.nextInt();

        int res = 0;
        switch (operation) {
            case "+":
                res = num1 + num2;
                System.out.printf("Результатом выражения %d + %d, является --> %d", num1, num2, res);
                break;
            case "-":
                res = num1 - num2;
                System.out.printf("Результатом выражения %d - %d, является --> %d", num1, num2, res);
                break;
            case "*":
                res = num1 * num2;
                System.out.printf("Результатом выражения %d * %d, является --> %d", num1, num2, res);
                break;
            case "/":
                if (num2 != 0) {
                    res = num1 / num2;
                    System.out.printf("Результатом выражения %d / %d, является --> %d", num1, num2, res);
                    break;
                } else {
                    System.out.print("Делить на 0 нельзя.");
                }
            case "**":
                double a = Integer.valueOf(num1);
                double b = Integer.valueOf(num2);
                double c;
                c = Math.pow(a, b);
                System.out.printf("Результатом выражения %d ** %d, является --> %.1f", num1, num2, c);
                break;
            default:
                System.out.println("\nТакой операции нет.");
                break;
        }
    }

    public static void task5() {
        /*
        Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
        например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение
        или сообщить, что его нет.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите выражение --> ");
        String eq = scanner.nextLine();
        String[] arr = eq.replace("?", "0").split(" ");

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        int c = Integer.parseInt(arr[4]);

//        System.out.printf("%d, %d, %d", a, b, c);

        int count = 0;

        // в зависимости от места знака, реализуем решение
        if (Objects.equals(arr[1], "+")) {
            if (a > 9) {
                for (int i = 0; i < 10; i++) {
                    int a1 = a + i;
                    if (b < 10) {
                        for (int j = 10; j < 100; j += 10) {
                            int b1 = b + j;
                            if (c > 9) {
                                for (int k = 0; k < 10; k++) {
                                    int c1 = a1 + b1;
                                    int c2 = c + k;
                                    if (c1 == c2) {
                                        count++;
                                        System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                        break;
                                    }
                                }
                            } else {
                                for (int k = 10; k < 100; k += 10) {
                                    int c1 = a1 + b1;
                                    int c2 = c + k;
                                    if (c1 == c2) {
                                        count++;
                                        System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                        break;
                                    }
                                }
                            }
                        }
                    } else{
                            for (int j = 0; j < 10; j++) {
                                int b1 = b + j;
                                if (c > 9) {
                                    for (int k = 0; k < 10; k++) {
                                        int c1 = a1 + b1;
                                        int c2 = c + k;
                                        if (c1 == c2) {
                                            count++;
                                            System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                            break;
                                        }
                                    }
                                } else {
                                    for (int k = 10; k < 100; k += 10) {
                                        int c1 = a1 + b1;
                                        int c2 = c + k;
                                        if (c1 == c2) {
                                            count++;
                                            System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                            break;
                                        }
                                    }
                                }
                            }
                    }
                }
        } else{
                for (int i = 10; i < 100; i += 10) {
                    int a1 = a + i;
                    if (b < 10) {
                        for (int j = 10; j < 100; j += 10) {
                            int b1 = b + j;
                            if (c > 9) {
                                for (int k = 0; k < 10; k++) {
                                    int c1 = a1 + b1;
                                    int c2 = c + k;
                                    if (c1 == c2) {
                                        count++;
                                        System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                        break;
                                    }
                                }
                            } else {
                                for (int k = 10; k < 100; k += 10) {
                                    int c1 = a1 + b1;
                                    int c2 = c + k;
                                    if (c1 == c2) {
                                        count++;
                                        System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        for (int j = 0; j < 10; j++) {
                            int b1 = b + j;
                            if (c > 9) {
                                for (int k = 0; k < 10; k++) {
                                    int c1 = a1 + b1;
                                    int c2 = c + k;
                                    if (c1 == c2) {
                                        count++;
                                        System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                        break;
                                    }
                                }
                            } else {
                                for (int k = 10; k < 100; k += 10) {
                                    int c1 = a1 + b1;
                                    int c2 = c + k;
                                    if (c1 == c2) {
                                        count++;
                                        System.out.printf("\nОдно из решений может быть таким --> %d + %d = %d", a1, b1, c2);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // если решения не найдено, выведем информацию
        if (count == 0) {
            System.out.println("Решения у такого выражения нет.");
        }
        // решение для других знаков и 3значных чисел
        // нужно думать универсальный метод, в который нужно подставлять только значения
//        else if (Objects.equals(arr[1], "-")) {
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    int res = i - j;
//                    if (res == c) {
//                        System.out.printf("\nОдно из решений может быть таким --> %d - %d = %d", i, j, res);
//                        break;
//                    }
//                }
//            }
//        }
    }
}