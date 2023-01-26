import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.lang.String.format;


/*
1. Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}} Задача написать метод(ы), который распарсить строку
и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
Используйте StringBuilder для подготовки ответа
2. Создать метод, который запишет результат работы в файл Обработайте исключения и запишите ошибки в лог файл
3. Получить исходную json строку из файла, используя FileReader или Scanner
4. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

public class Main {
    public static void main(String[] args) {
        System.out.print("Приветствую! Можете выбрать 1 из 2 задач.\n" +
                "1. Считывание данныйх из json файла и преобразование с записью в новый файл.\n" +
                "2. Алгоритм сортировки пузырьком с записью каждой итерацции в лог-файл.\n");
        System.out.print("Введите номер задачи --> ");
        Scanner aScanner = new Scanner(System.in);
        int taskNum = aScanner.nextInt();

        switch (taskNum) {
            case 1:
                HW_1_3();
                break;
            case 2:
                HW4();
                break;
            default:
                System.out.println("\nТакого задания нет.");
                break;
        }
    }

    static void HW_1_3() {
        // создаём логгер
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("LogHW13.txt");
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        logger.addHandler(fileHandler);

        // читаем файл, и добавляем данные в sb
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("studentsHW13.json"))) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append('\n');
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        // парсим и записываем в текстовый файл в нужном формате вывод данных
        String[] pars_text = sb.toString().replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace(",", "")
                .replace("\n", "")
                .replace("   ", "")
                .split("}");

        Map<String, String> dict = new HashMap<>();
        File file = new File("output_dataHW13.txt");

        for (int i = 0; i < pars_text.length; i++) {
            String[] student = pars_text[i].split(" ");
            for (int j = 0; j < student.length; j++) {
                String[] keyValue = student[j].replace("\"", "").split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                dict.put(key, value);
            }
            String result = format("Студент %s получил %s по предмету %s.\n", dict.get("фамилия"), dict.get("оценка"), dict.get("предмет"));
            try (FileWriter fW = new FileWriter(file, true)) {
                fW.write(result);
            } catch (Exception e) {
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }

    static void HW4(){
        // создаём логгер
        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("LogHW4.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        logger.addHandler(fileHandler);

        //создадим массив и заполним его
        int[] list_ = new int[10];
        for (int i = 0; i < list_.length; i++) {
            Random random = new Random();
            list_[i] = random.nextInt(50);
        }
        File file = new File("output_dataHW4.txt");

        try (FileWriter fW = new FileWriter(file, true)) {
            fW.write(format("Полученный массив: %s\n",Arrays.toString(list_)));
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        // сортировка
        int len = 0;
        int count = 0;
        boolean flag = true;
        while (len < list_.length - 1) {
            flag = false;
            for (int i = 1; i < list_.length - len; i++) {
                if (list_[i - 1] > list_[i]) {
                    int temp = list_[i - 1];
                    list_[i - 1] = list_[i];
                    list_[i] = temp;
                    count++;
                    logger.log(Level.INFO, String.format("Ход %s, преобразованный массив %s\n", count, Arrays.toString(list_)));
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
            len++;
        }
        try (FileWriter fW = new FileWriter(file, true)) {
            fW.write(format("Массив после сортировки: %s\n",Arrays.toString(list_)));
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}
