import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


    }

    static void task1(){
        // Пусть дан произвольный список целых чисел, удалить из него четные числа

        Random random = new Random();
        int n = random.nextInt(100);  // случайный размер массива
        List<Integer> list = new ArrayList<Integer>();

        // заполняем массив случайными данными
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        System.out.printf("Полученный массив - %s\n", list);

        // проходим по массиву и удаляем четные числа
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.printf("Массив, после удаления чётных чисел - %s\n", list);
    }

    static void task2() {
        /*
        Задан целочисленный список ArrayList. Найти минимальное, максимальное и
        среднее арифметическое из этого списка. Collections.max()
        */

        Random random = new Random();
        int n = random.nextInt(100);  // случайный размер массива
        System.out.printf("Размер массива - %d\n", n);
        List<Integer> list = new ArrayList<Integer>();

        // заполняем массив
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(1000));
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        double average = sum / list.size();

        System.out.printf("Полученный массив - %s\n", list);
        System.out.printf("Минимальное число массива - %s\n", Collections.min(list));
        System.out.printf("Максимальное число массива - %s\n", Collections.max(list));
        System.out.printf("Среднее арифметическое число массива - %.1f\n", average);


    }

    static void task3() {
        // Реализовать алгоритм сортировки слиянием


    }
}