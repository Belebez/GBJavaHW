import java.util.*;

public class MyPhoneBook {

    Map<String, List<String>> map = new HashMap<>();

    @Override
    public String toString() {
        return map.toString();
    }

    void addNew(String s) {
        String[] nameNum = s.split(" ");

        for (int i = 0; i < 2; i++) {
            if (map.containsKey(nameNum[0])) {
                for (int j = 2; j < nameNum.length; j++) {
                    List<String> list = map.get(nameNum[0]);
                    list.add(nameNum[j]);
                }
            } else {
                List<String> list = new ArrayList<>();
                list.add(nameNum[1]);
                map.put(nameNum[0], list);
            }
        }
    }

    void searchContact(String s){

        Set<String> set = map.keySet();
        String substr = s.toLowerCase();

        System.out.println("\nНашлись следующие контакты: \n");

        for (String word: set) {
            if (word.toLowerCase().contains(substr)) {
                System.out.printf("%s %s\n", word, map.get(word));
            }
        }
    }

    void changeKey(String s) {
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < map.size(); i++) {
                if (map.containsKey(s)) {
                    List<String> list = map.get(s);
                    System.out.print("\nВведите новое имя --> ");
                    Scanner scanner = new Scanner(System.in);
                    String newName = scanner.nextLine();
                    map.put(newName, list);
                    System.out.print("\nДанный заменены.\n");
                    map.remove(s);
                    flag = false;
                    break;
                } else {
                    System.out.println("Такого контакта нет. Попробуйте еще раз.");
                    flag = false;
                    break;
                }
            }
        }
    }

    void changeNumber(String s){
        if (map.containsKey(s)) {
            List<String> list = new ArrayList<String>();
            System.out.print("\nВведите новый номер --> ");
            Scanner scanner = new Scanner(System.in);
            String newNum = scanner.nextLine();
            list.add(newNum);
            map.put(s, list);
        }
    }

    void addNumber(String s){
        if (map.containsKey(s)) {
            List<String> list = map.get(s);
            System.out.print("\nВведите дополнительный номер --> ");
            Scanner scanner = new Scanner(System.in);
            String newNum = scanner.nextLine();
            list.add(newNum);
            map.put(s, list);
        }
    }

    void removeContact(String s){
        map.remove(s);
        System.out.println("\nКонтакт удалён.\n");
    }
}
