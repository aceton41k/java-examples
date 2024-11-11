import java.util.*;

/**
 * Filter students with score more than 60 and sort by name
 */
public class StudentsFilter {
    static Map<String, Integer> students = Map.of(
            "John", 55,
            "Serge", 61,
            "Maria", 70,
            "Kelly", 36,
            "Anna", 80
    );

    public static void main(String[] args) {
        System.out.println(filter(students));
    }

    public static List<String> filter(Map<String, Integer> students) {
        return students.entrySet().stream().filter(entry -> entry.getValue() > 60).map(Map.Entry::getKey).sorted().toList();
    }
}
