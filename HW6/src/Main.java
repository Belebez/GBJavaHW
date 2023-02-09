import java.util.*;

public class Main {
    public static void main(String[] args) {
        NoteBook noteBook0 = new NoteBook("Acer", "Linux", "Black", 1000, 8, 50000);
        NoteBook noteBook1 = new NoteBook("Acer", "Linux", "Grey", 2000, 16, 75000);
        NoteBook noteBook2 = new NoteBook("Asus", "Linux", "Black", 1000, 12, 65000);
        NoteBook noteBook3 = new NoteBook("HP", "Windows", "White", 500, 8, 75000);
        NoteBook noteBook4 = new NoteBook("Samsung", "Windows", "Red", 500, 8, 80000);
        NoteBook noteBook5 = new NoteBook("MSI", "noOs", "Black", 2000, 32, 170000);
        NoteBook noteBook6 = new NoteBook("Thunderobot", "noOs", "Grey", 1000, 16, 120000);
        NoteBook noteBook7 = new NoteBook("Apple", "MacOs", "Grey", 250, 8, 120000);
        NoteBook noteBook8 = new NoteBook("Apple", "MacOs", "Grey", 500, 16, 150000);

        Set<NoteBook> noteBooks = new HashSet<>();
        noteBooks.add(noteBook0);
        noteBooks.add(noteBook1);
        noteBooks.add(noteBook2);
        noteBooks.add(noteBook3);
        noteBooks.add(noteBook4);
        noteBooks.add(noteBook5);
        noteBooks.add(noteBook6);
        noteBooks.add(noteBook7);
        noteBooks.add(noteBook8);


        System.out.print("Приветствую! Рад вас видеть в нашем интернет магазине.\n" +
                "Вы можете:\n" +
                "1. Посмотреть полный список техники.\n" +
                "2. Фильтровать по параметрам.\n" +
                "\n" +
                "0. Выход.\n");

        System.out.print("\nВведите номер задачи --> ");
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch (taskNum) {
            case 1:
                System.out.println(noteBooks);
                break;
            case 2 :
                System.out.print("Отфильтровать по:\n" +
                        "1. Производитель\n" +
                        "2. Операционная система\n" +
                        "3. Цвет\n" +
                        "4. Объём ЖД\n" +
                        "5. Объём ОЗУ\n" +
                        "6. Цена\n" +
                        "\n" +
                        "0. Сортировка по нескольким параметрам\n");

                System.out.print("\nВведите номер параметра --> ");
                Scanner scanner1 = new Scanner(System.in);
                int taskNum1 = scanner1.nextInt();
                switch (taskNum1){
                    case 1 :
                        System.out.print("Введите производителя --> ");
                        Scanner scanner2 = new Scanner(System.in);
                        String manufac = scanner2.nextLine().toLowerCase();
                        int count = 0;
                        for (NoteBook note: noteBooks) {
                            if (note.manufacture.toLowerCase().contains(manufac)){
                                count++;
                                System.out.println(note);
                            }
                        }
                        if (count > 0) {
                            System.out.println("\nЭто всё, что есть на нашем складе\n");
                        } else {
                            System.out.println("\nК сожалению, такой параметр не дал результат\n");
                        }
                        break;
                    case 2 :
                        System.out.print("Введите тип ОС --> ");
                        Scanner scanner3 = new Scanner(System.in);
                        String operSys = scanner3.nextLine().toLowerCase();
                        int count1 = 0;
                        for (NoteBook note: noteBooks) {
                            if (note.oS.toLowerCase().contains(operSys)){
                                count1++;
                                System.out.println(note);
                            }
                        }
                        if (count1 > 0) {
                            System.out.println("\nЭто всё, что есть на нашем складе\n");
                        } else {
                            System.out.println("\nК сожалению, такой параметр не дал результат\n");
                        }
                        break;
                    case 3 :
                        System.out.print("Введите цвет ноутбука --> ");
                        Scanner scanner4 = new Scanner(System.in);
                        String noteColor = scanner4.nextLine().toLowerCase();
                        int count2 = 0;
                        for (NoteBook note: noteBooks) {
                            if (note.color.toLowerCase().contains(noteColor)){
                                count2++;
                                System.out.println(note);
                            }
                        }
                        if (count2 > 0) {
                            System.out.println("\nЭто всё, что есть на нашем складе\n");
                        } else {
                            System.out.println("\nК сожалению, такой параметр не дал результат\n");
                        }
                        break;
                    case 4 :
                        System.out.print("Введите минимальный объём ЖД --> ");
                        Scanner scanner5 = new Scanner(System.in);
                        int noteCapacityHDD = scanner5.nextInt();
                        int count3 = 0;
                        for (NoteBook note: noteBooks) {
                            if (note.hardDisk >= noteCapacityHDD){
                                count3++;
                                System.out.println(note);
                            }
                        }
                        if (count3 > 0) {
                            System.out.println("\nЭто всё, что есть на нашем складе\n");
                        } else {
                            System.out.println("\nК сожалению, такой параметр не дал результат\n");
                        }
                        break;
                    case 5 :
                        System.out.print("Введите минимальный объём ОЗУ --> ");
                        Scanner scanner6 = new Scanner(System.in);
                        int noteRam = scanner6.nextInt();
                        int count4 = 0;
                        for (NoteBook note: noteBooks) {
                            if (note.ram >= noteRam){
                                count4++;
                                System.out.println(note);
                            }
                        }
                        if (count4 > 0) {
                            System.out.println("\nЭто всё, что есть на нашем складе\n");
                        } else {
                            System.out.println("\nК сожалению, такой параметр не дал результат\n");
                        }
                        break;
                    case 6 :
                        System.out.print("Введите максимальную цену ноутбука --> ");
                        Scanner scanner7 = new Scanner(System.in);
                        int notePrice = scanner7.nextInt();
                        int count5 = 0;
                        for (NoteBook note: noteBooks) {
                            if (note.price <= notePrice){
                                count5++;
                                System.out.println(note);
                            }
                        }
                        if (count5 > 0) {
                            System.out.println("\nЭто всё, что есть на нашем складе\n");
                        } else {
                            System.out.println("\nК сожалению, такой параметр не дал результат\n");
                        }
                        break;
                    case 0 :
                        System.out.print("Введите до 3 параметров для выборки, через пробел --> ");  // будем надеяться, что так и будет)
                        Scanner sc = new Scanner(System.in);
                        String[] noteParam = sc.nextLine().toLowerCase().split(" ");
                        ArrayList<Integer> noteDigitParam = new ArrayList<>();
                        ArrayList<String> noteStringParam = new ArrayList<>();

                        for (String word: noteParam) {
                            char c = word.charAt(0);
                            if (c >= 'a' && c <= 'z') {
                                noteStringParam.add(word);
                            } else {
                                noteDigitParam.add(Integer.parseInt(word));
                            }
                        }
                        Set<NoteBook> noteBooks1 = new HashSet<>();
                        Set<NoteBook> noteBooks2 = new HashSet<>();
                        Set<NoteBook> noteBooks3 = new HashSet<>();

                        if ((noteDigitParam.size() == 1) && (noteStringParam.size() == 1)) {
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks) {
                                    if ((note.manufacture.equalsIgnoreCase(noteStringParam.get(i))
                                            || (note.oS.equalsIgnoreCase(noteStringParam.get(i)))
                                            || (note.color.equalsIgnoreCase(noteStringParam.get(i))))) {
                                        noteBooks1.add(note);
                                    }
                                }
                            }
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks1) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    }
                                }
                            }
                            System.out.println(noteBooks2);
                        } else if ((noteDigitParam.size() == 1) && (noteStringParam.size() == 2)) {
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks) {
                                    if ((note.manufacture.equalsIgnoreCase(noteStringParam.get(i))
                                            || (note.oS.equalsIgnoreCase(noteStringParam.get(i)))
                                            || (note.color.equalsIgnoreCase(noteStringParam.get(i))))) {
                                        noteBooks1.add(note);
                                    }
                                }
                            }
                            for (int i = 1; i < 2; i++) {
                                for (NoteBook note : noteBooks1) {
                                    if ((note.manufacture.equalsIgnoreCase(noteStringParam.get(i))
                                            || (note.oS.equalsIgnoreCase(noteStringParam.get(i)))
                                            || (note.color.equalsIgnoreCase(noteStringParam.get(i))))) {
                                        noteBooks2.add(note);
                                    }
                                }
                            }
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks2) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    }
                                }
                            }
                            System.out.println(noteBooks3);
                    } else if ((noteDigitParam.size() == 2) && (noteStringParam.size() == 1)) {
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks) {
                                    if ((note.manufacture.equalsIgnoreCase(noteStringParam.get(i))
                                            || (note.oS.equalsIgnoreCase(noteStringParam.get(i)))
                                            || (note.color.equalsIgnoreCase(noteStringParam.get(i))))) {
                                        noteBooks1.add(note);
                                    }
                                }
                            }
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks1) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    }
                                }
                            }
                            for (int i = 1; i < 2; i++) {
                                for (NoteBook note : noteBooks2) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    }
                                }
                            }
                            System.out.println(noteBooks3);
                        } else if ((noteDigitParam.size() == 3) && (noteStringParam.isEmpty())) {
                            for (int i = 0; i < 1; i++) {
                                for (NoteBook note : noteBooks) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks1.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks1.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks1.add(note);
                                        }
                                    }
                                }
                            }
                            for (int i = 1; i < 2; i++) {
                                for (NoteBook note : noteBooks1) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks2.add(note);
                                        }
                                    }
                                }
                            }
                            for (int i = 2; i < 3; i++) {
                                for (NoteBook note : noteBooks2) {
                                    if (noteDigitParam.get(i) < 100) {
                                        if (note.ram >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) < 5000) {
                                        if (note.hardDisk >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    } else if (noteDigitParam.get(i) > 5000) {
                                        if (note.price >= noteDigitParam.get(i)) {
                                            noteBooks3.add(note);
                                        }
                                    }
                                }
                            }
                            System.out.println(noteBooks3);
                        }
                        break;
                    default:
                        System.out.println("\nТакого задания нет.");
                        break;
                }
                break;
            case 0 :
                System.out.println("\nВсего доброго, до новых встреч)\n");
                break;
            default:
                System.out.println("\nТакого задания нет.");
                break;
        }
    }


}