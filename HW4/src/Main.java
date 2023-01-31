import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = null;
        System.out.print("Приветствую! Выберите одну из трёх задач.\n" +
                "1. Дан LinkedList с несколькими элементами. Программа возвращает “перевернутый” список.\n" +
                "2. Очередь LinkedList со следующими методами:\n" +
                "  - enqueue() - помещает элемент в конец очереди\n" +
                "  - dequeue() - возвращает первый элемент из очереди и удаляет его\n" +
                "  - first() - возвращает первый элемент из очереди, не удаляя.\n" +
                "3. Дан LinkedList, программа возвращает сумму элементов и сохраняет все элементы в списке.\n");

        System.out.print("\nВведите номер задачи --> ");
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch (taskNum) {
            case 1:
                task1();
                break;
            case 2:
                System.out.print("\nВведите размер списка --> ");
                Scanner scanner2 = new Scanner(System.in);
                int num = scanner2.nextInt();
                myQueue = new MyQueue(num);
                boolean flag = true;
                while (flag) {
                    System.out.print("\nВыберите какой хотите использовать метод\n" +
                            "1. Печать списка\n" +
                            "2. enqueue() - помещает элемент в конец очереди\n" +
                            "3. dequeue() - возвращает первый элемент из очереди и удаляет его\n" +
                            "4. first() - возвращает первый элемент из очереди, не удаляя.\n" +
                            "\n" +
                            "0. Выход\n");
                    System.out.print("\nВведите номер задачи --> ");
                    Scanner scanner1 = new Scanner(System.in);
                    int taskNum1 = scanner1.nextInt();
                    switch (taskNum1) {
                        case 1:
                            System.out.printf("\nСписок - %s\n", myQueue.toString());
                            break;
                        case 2 :
                            System.out.print("\nВведите число, какое хотите добавить --> ");
                            Scanner scanner3 = new Scanner(System.in);
                            int newNum = scanner3.nextInt();
                            myQueue.enqueue(newNum);
                            break;
                        case 3 :
                            System.out.printf("\nБывший первый элемент списка - %d\n", myQueue.dequeue());
                            break;
                        case 4 :
                            System.out.printf("\nПервый элемент списка - %d\n", myQueue.first());
                            break;
                        case 0 :
                            System.out.println("\nВсего доброго.\n");
                            flag = false;
                            break;
                        default:
                            System.out.println("\nТакого номера нет.");
                            break;
                    }
                }
                break;
            case 3:
                task3();
                break;
            default:
                System.out.println("\nТакого задания нет.");
                break;

                }
        }

        static void task1 () {
        /*
        Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        */
            LinkedList<Integer> list1 = new LinkedList<>();
            Random random = new Random();
            int n = random.nextInt(30);

            for (int i = 0; i < n; i++) {
                list1.add(random.nextInt(100));
            }
            System.out.printf("Полученный список - %s\n", list1);

            LinkedList<Integer> list2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list2.add(list1.pollLast());
            }
            System.out.printf("Перевернутный список - %s\n", list2);
        }

        static void task3 () {
        /*
        Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
        */

            LinkedList<Integer> list = new LinkedList<>();
            Random random = new Random();
            int n = random.nextInt(100);

            for (int i = 0; i < n; i++) {
                list.add(random.nextInt(100));
            }
            System.out.printf("Полученный список - %s\n", list);

            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            System.out.printf("Сумма всех элементов - %d\n", sum);

//        ListIterator<Integer> iterator = list.listIterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            sum += integer;
//        }

        }
    }