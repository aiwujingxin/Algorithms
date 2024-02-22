package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 15:01
 */
public class LeetCode791 {

    public String customSortString(String order, String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Character o1, Character o2) {
                return orderMap.getOrDefault(o1, -1) - orderMap.getOrDefault(o2, -1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }
}
