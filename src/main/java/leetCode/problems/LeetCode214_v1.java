package leetCode.problems;

import java.util.HashMap;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/4 22:09
 */
public class LeetCode214_v1 {

    //https://leetcode.com/problems/shortest-palindrome/discuss/60238/O(n)-solution-based-on-HashMaps-(No-Manacher-No-KMP)

    private <T> void removeOne(HashMap<T, Integer> map, T key) {
        int value = map.get(key);
        if (value == 1) {
            map.remove(key);
        } else {
            map.put(key, value - 1);
        }
    }

    private <T> void addValue(HashMap<T, Integer> map, T key, int value) {
        Integer val = map.get(key);
        if (val == null) {
            map.put(key, value);
        } else {
            map.put(key, val + value);
        }
    }


    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> sum = new HashMap<>();
        HashMap<Double, Integer> averages = new HashMap<>();

        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            addValue(count, c, 1);
            addValue(sum, c, i);
        }
        for (char c : count.keySet()) {
            double d = (1.0 * sum.get(c)) / (double) count.get(c);
            addValue(averages, d, 1);
        }
        StringBuilder sb = new StringBuilder();
        if (averages.size() == 1) {
            sb.append(s);
            return sb.toString();
        }
    /*
      starting from the far right in the string, we remove character by character,
      and check in constant time whether the remaining string is a palindrome
      (the average position of all characters is equal)
    */
        for (int i = chars.length - 1; i > 0; --i) {
            sb.append(chars[i]);
            int cou = count.get(chars[i]);
            int su = sum.get(chars[i]);
            double avg = (1.0 * su) / cou;
            removeOne(averages, (1.0 * su) / cou);

            if (cou == 1) {
                count.remove(chars[i]);
                sum.remove(chars[i]);
            } else {
                count.put(chars[i], cou - 1);
                sum.put(chars[i], su - i);
                avg = (1.0 * (su - i)) / (cou - 1);
                addValue(averages, avg, 1);
            }
            if (averages.size() == 1) {
                sb.append(s);
                return sb.toString();
            }
        }
        sb.append(s);
        return sb.toString();
    }
}
