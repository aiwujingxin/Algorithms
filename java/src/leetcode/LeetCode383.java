package leetcode;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2021-12-26 9:08 PM
 */

public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null && magazine == null) {
            return true;
        }
        if (magazine == null) {
            return false;
        }
        if (ransomNote == null) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            map.put(c, (map.getOrDefault(c, 0) + 1));
        }
        for (int i = 0; i < ransomNote.toCharArray().length; i++) {
            Character c = ransomNote.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) - 1 == 0) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }

            }
        }
        return true;
    }
}
