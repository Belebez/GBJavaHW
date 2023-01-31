import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("Приветствую! Выберите одну из трёх задач.\n" +
                "1. Программа создаёт произвльный список целых чисел и удаляет из него чётные.\n" +
                "2. Задан произвольный целочисленный список. Программа ищет минимальное,\n" +
                "максимальное и среднее арифметическое из этого списка.\n" +
                "3. Алгоритм сортировки слиянием.\n");

        System.out.print("Введите номер задачи --> ");
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch (taskNum) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
//                task3();
                System.out.println("Пока алгоритм в доработке..");
                break;
            default :
                System.out.println("\nТакого задания нет.");
                break;
        }

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
//        // Реализовать алгоритм сортировки слиянием
//        Random random = new Random();
//        int n = 10; // пусть пока такой размер
//        System.out.printf("Размер массива - %d\n", n);
//        List<Integer> list_ = new ArrayList<Integer>();
//
//        // заполняем массив
//        for (int i = 0; i < n; i++) {
//            list_.add(random.nextInt(100));
//        }
//
//        void mergeSort() {
//
//        }
//
//        int[] merge() {
//            int[] leftArr = new int[];
//            int[] rightArr = new int[];
//
//            for (int i = 0; i < leftArr.length; i++) {
//
//            }
//            for (int i = 0; i < rightArr.length; i++) {
//
//            }
//
//
//
//        }


    }
}


/* За основу возьмём, ранее сделанную быструю сортировку, она немного похожа.
// 1. arr = {1, 0, -6, 2, 5, 3, 2}
// 2. pivot = arr[6]  (опорный элемент)
// 3. Вызвать шаги 1-2 для подмассива слева от pivot и справа от pivot
//
// Опорный элемент стоит в начале

int size = new Random().Next(4, 21);
int[] arr = GetArray(size);
PrintArray(arr);
QuickSort(arr, 0, arr.Length - 1);
Console.Write($"Отсортированный массив {string.Join(", ", arr)}");


int[] GetArray(int m)  // функция заполнения массива
{
int[] result = new int[m];
for (int i = 0; i < m; i++)
{
result[i] = new Random().Next(-100, 101);
}
return result;
}

void QuickSort(int[] inputArray, int minIndex, int maxIndex)
{
if (minIndex >= maxIndex) return;
int pivot = GetPivotIndex(inputArray, minIndex, maxIndex);
QuickSort(inputArray, minIndex, pivot - 1);
QuickSort(inputArray, pivot + 1, maxIndex);
return;
}

int GetPivotIndex(int[] inputArray, int minIndex, int maxIndex)
{
int pivotIndex = minIndex - 1;
for (int i = minIndex; i <= maxIndex; i++)
{
if (inputArray[i] < inputArray[maxIndex])
{
pivotIndex++;
Swap(ref inputArray[pivotIndex], ref inputArray[i]);
}
}
pivotIndex++;
Swap(ref inputArray[pivotIndex], ref inputArray[maxIndex]);
return pivotIndex;
}

void Swap(ref int leftValue, ref int rightValue)
{
int temp = leftValue;
leftValue = rightValue;
rightValue = temp;
}

void PrintArray(int[] array)
{
Console.Write("Полученный массив: ");
for (int i = 0; i < array.GetLength(0); i++)
{
Console.Write($" {array[i] }");
}
Console.WriteLine();

*/