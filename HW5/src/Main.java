import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MyPhoneBook myPhoneBook = new MyPhoneBook();
        System.out.print("Приветствую! Выберите одну из трёх задач.\n" +
                "1. Телефонная книга с помощью HashMap.\n" +
                "2. Дан, список сотрудников. Программа, выводит повторяющиеся имена с количеством повторений.\n" +
                "3. Алгоритм пирамидальной сортировки (HeapSort)\n" +
                "4. Программа расставляет на шахматной доске 8 ферзей так, чтобы они не били друг друга.\n");

        System.out.print("\nВведите номер задачи --> ");
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch (taskNum) {
            case 1:
                boolean flag = true;
                while (flag) {
                    System.out.print("\nВыберите какой хотите использовать метод\n" +
                            "1. Печать книги.\n" +
                            "2. Найти контакта.\n" +
                            "3. Добавить контакт.\n" +
                            "4. Изменить контакт.\n" +
                            "5. Удалить контакт.\n" +
                            "\n" +
                            "0. Выход\n");
                    System.out.print("\nВведите номер задачи --> ");
                    Scanner scanner1 = new Scanner(System.in);
                    int taskNum1 = scanner1.nextInt();
                    switch (taskNum1) {
                        case 1:
                            System.out.printf("\nТелефонная книга - %s\n", myPhoneBook.toString());
                            break;
                        case 2:
                            System.out.print("\nВведите полное имя или часть для поиска --> ");
                            Scanner scanner7 = new Scanner(System.in);
                            String s2 = scanner7.nextLine();
                            myPhoneBook.searchContact(s2);
                            break;
                        case 3:
                            System.out.print("\nВведите фамилию и номер(а) телефона, через пробел --> ");
                            Scanner scanner3 = new Scanner(System.in);
                            String string = scanner3.nextLine();
                            myPhoneBook.addNew(string);
                            break;
                        case 4:
                            System.out.print("\nВведите фамилию контакта --> ");
                            Scanner scanner5 = new Scanner(System.in);
                            String s = scanner5.nextLine();
                            if (myPhoneBook.map.containsKey(s)) {
                                System.out.print("\nС контактом можно совершить следующие действия:\n" +
                                        "   1. Изменить фамилию.\n" +
                                        "   2. Изменить номер.\n" +
                                        "   3. Добавить номер.\n");
                                System.out.print("\nВведите номер --> ");
                                Scanner scanner4 = new Scanner(System.in);
                                int num = scanner4.nextInt();
                                switch (num) {
                                    case 1:
                                        myPhoneBook.changeKey(s);
                                        break;
                                    case 2:
                                        myPhoneBook.changeNumber(s);
                                        break;
                                    case 3:
                                        myPhoneBook.addNumber(s);
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                System.out.println("\nТакого контакта нет.");
                            }
                        case 5 :
                            System.out.print("\nВведите фамилию контакта --> ");
                            Scanner scanner6 = new Scanner(System.in);
                            String s1 = scanner6.nextLine();
                            if (myPhoneBook.map.containsKey(s1)) {
                                myPhoneBook.removeContact(s1);
                            } else {
                                System.out.println("\nТакого контакта нет.");
                            }
                            break;
                    }
                }
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
            default:
                System.out.println("\nТакого задания нет.");
                break;
        }
    }

        static void task2 () {
        /*
        Пусть дан список сотрудников:

        Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков,um
        Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,
        Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.

        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
         */

            String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, \n" +
                    "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, \n" +
                    "Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";

            String[] staff = s.replace(".", "").replace(",", "").replace("\n", "")
                    .split(" ");
            TreeMap<String, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < staff.length; i += 2) {
                if (treeMap.containsKey(staff[i])) {
                    int count = treeMap.get(staff[i]);
                    count++;
                    treeMap.put(staff[i], count);
                } else {
                    int count = 1;
                    treeMap.put(staff[i], count);
                }
            }

            // ничего другого не нашёл, как использовать компоратор, только через лист.
            List list = new ArrayList(treeMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            });
            System.out.printf("\nСписок сотрудников:\n%s\n", s);
            System.out.printf("\nСписок имён и повторений - %s", list);
        }

        static void task3 () {
        /*
        Реализовать алгоритм пирамидальной сортировки (HeapSort)
         */

            System.out.println("Решения пока нет..  (");
        }

        static void task4 () {
        /*
        На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
         */

            int[][] chess = new int[8][8];

//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    chess[i][j] = 0;
//                }
//            }
//            for (int i = 0; i < chess.length; i++) {
//                for (int j = 0; j < chess[0].length; j++) {
//                    System.out.print(" " + chess[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println("Решения пока нет...(");

        }
}
