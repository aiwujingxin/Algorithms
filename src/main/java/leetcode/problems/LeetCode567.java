package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 19:57
 */
public class LeetCode567 {

    //"pqzhi"
    //"ghrqpihzybre"

    public static void main(String[] args) {
        System.out.println(new LeetCode567().checkInclusion("ab", "eidbaooo"));
        System.out.println(new LeetCode567().checkInclusion("adc", "dcda"));
        System.out.println(new LeetCode567().checkInclusion("pqzhi", "ghrqpihzybre"));
    }

    //"adc"
    //"eeedeasdacdadocddda"

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character s : s1.toCharArray()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int left = 0;
        while (left < s2.length()) {
            if (map.containsKey(s2.charAt(left))) {
                HashMap<Character, Integer> map1 = new HashMap<>();
                map1.put(s2.charAt(left), 1);
                int right = left + 1;
                int count = 1;
                while (count < s1.length() && right < s2.length()) {
                    if (!map.containsKey(s2.charAt(right))) {
                        left = right;
                        break;
                    }
                    map1.put(s2.charAt(right), map1.getOrDefault(s2.charAt(right), 0) + 1);
                    right++;
                    count++;
                }
                if (count == s1.length() && map.equals(map1)) {
                    return true;
                }
            }
            left++;
        }
        return false;
    }
}
