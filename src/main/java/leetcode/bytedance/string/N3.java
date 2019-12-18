package leetcode.bytedance.string;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 567
 */
public class N3 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = s1.toCharArray();
        for (char c : chars1) {
            addOne(map1, c);
        }
        char[] chars2 = s2.toCharArray();
        int n1 = chars1.length;
        for (int i = 0; i < n1; i++) {
            addOne(map2, chars2[i]);
        }
        if (map1.equals(map2)) {
            return true;
        }
        int i = n1;
        while (i < chars2.length) {
            subOne(map2, chars2[i - n1]);
            addOne(map2, chars2[i]);
            i++;
            if (map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }

    private void addOne(Map<Character, Integer> map, Character character) {
        Integer number = map.get(character);
        if (number == null) {
            number = 0;
        }
        map.put(character, number + 1);
    }

    private void subOne(Map<Character, Integer> map, Character character) {
        Integer number = map.get(character);
        if (number == 0) {
            throw new RuntimeException("number is 0");
        }
        number--;
        if (number == 0) {
            map.remove(character);
        } else {
            map.put(character, number);
        }
    }
}
