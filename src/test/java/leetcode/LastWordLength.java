package leetcode;

public class LastWordLength {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(Solution.lengthOfLastWord(s));
    }

    static class Solution {
        public static int lengthOfLastWord(String s) {
            int wordsCount = 0;
            for (int i = s.trim().length() - 1; i >= 0; i--) {
                if (isLetter(s.charAt(i)))
                    wordsCount++;
                if (s.trim().charAt(i) == ' ') break;
            }
            return wordsCount;
        }

        public static boolean isLetter(char h) {
            String letters = "qwertyuiopasdfghjklzxcvbnm";
            letters = letters + letters.toUpperCase();
            for (int i = 0; i < letters.length(); i++) {
                if (letters.charAt(i) == h)
                    return true;
            }
            return false;
        }
    }
}
