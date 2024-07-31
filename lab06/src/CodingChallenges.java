import java.util.*;

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
        Set<Integer> seen = new HashSet<>();
        for (int x : values) {
            seen.add(x);
        }
        for(int i = 0; i <= values.length; i++) {
            if(!seen.contains(i)) {
                return i;
            }
        }




        return -1;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Map<Character, Integer> characterCounts1 = new HashMap<>();
        Map<Character, Integer> characterCounts2 = new HashMap<>();
        for(char x : chars1) {
            if(!characterCounts1.containsKey(x)) {
                characterCounts1.put(x , 1);
            } else {
                characterCounts1.put(x , characterCounts1.get(x) + 1);
            }
        }
        for(char x : chars2) {
            if(!characterCounts2.containsKey(x)) {
                characterCounts2.put(x , 1);
            } else {
                characterCounts2.put(x , characterCounts2.get(x) + 1);
            }
        }
        for(char x : chars1) {
            if(!Objects.equals(characterCounts1.get(x), characterCounts2.get(x))) {
                return false;
            }
        }
        for(char x : chars2) {
            if(!Objects.equals(characterCounts1.get(x), characterCounts2.get(x))) {
                return false;
            }
        }

        return true;
    }
}
