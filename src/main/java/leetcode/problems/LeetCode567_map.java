package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 21:14
 */
public class LeetCode567_map {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hs1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hs1.put(ch, hs1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> hs2 = new HashMap<>();

        int n = s1.length();
        int i = 0;
        int j = 0;

        while (j < s2.length()) {
            char ch2 = s2.charAt(i);
            char ch = s2.charAt(j);
            hs2.put(ch, hs2.getOrDefault(ch, 0) + 1);
            int len = (j - i) + 1;
            if (len == n) {
                if (hs1.equals(hs2)) {
                    return true;
                } else {
                    int temp = hs2.get(ch2);
                    if (temp == 1) {
                        hs2.remove(ch2);
                    } else {
                        hs2.put(ch2, temp - 1);
                    }
                    i++;
                }
            }
            j++;
        }
        return false;
    }
}
