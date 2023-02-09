/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */

public class NoteBook {
    String manufacture;
    String oS;
    String color;
    int hardDisk;
    int ram;
    int price;

    public NoteBook(String manufacture, String oS, String color, int hardDisk, int ram, int price) {
        this.manufacture = manufacture;
        this.oS = oS;
        this.color = color;
        this.hardDisk = hardDisk;
        this.ram = ram;
        this.price = price;
    }


    @Override
    public String toString() {
        return "\nНоутбук:\n" +
                "1. Производитель = " + manufacture + "\n" +
                "2. Операционная система = " + oS + "\n" +
                "3. Цвет = " + color + "\n" +
                "4. Объём диска = " + hardDisk + "Gb\n" +
                "5. ОЗУ = " + ram + "\n" +
                "6. Цена = " + price + " руб.\n";
    }
}
