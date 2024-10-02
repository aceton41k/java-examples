import java.util.*;

public class MaxOccurrenceInString {
    public static void main(String[] args) {
        String s = "xxxxxthkoioiiaacccc";
        String s2 = "";
        String s3 = "g";

        System.out.println(maxOcc(s3));
    }

    public static char maxOcc(String s) {
        if (s.isEmpty()) return 0;
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }
        char output = 0;
        int maxValue = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxValue < entry.getValue()) {
                maxValue = entry.getValue();
                output = entry.getKey();
            }
        }
        return output;
    }

}
