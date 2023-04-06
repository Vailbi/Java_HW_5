import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        showEntryList(personals);
    }

    public static List<String> personals = new ArrayList<>(Arrays.asList(
            "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"
    ));


    public static void removeOneRepeatNames(Map<String, Integer> map) {
        map.entrySet().removeIf(entry -> entry.getValue() == 1);
    }
    public static void showEntryList(List<String> personals) {
        Map<String, Integer> map = new HashMap<>();
        for (String personal : personals) {
            String personalName = personal.split(" ")[0];
            if (map.containsKey(personalName)) {
                map.put(personalName, map.get(personalName) + 1);
            } else {
                map.put(personalName, 1);
            }
        }
        removeOneRepeatNames(map);
        List<Map.Entry<String, Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        System.out.println(lst);
    }
}