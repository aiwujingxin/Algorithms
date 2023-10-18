package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 23:15
 */
public class LeetCode451 {

    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getValue(), entry.getKey()});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int[] ints : list) {
            int cnt = ints[0];
            for (int j = 0; j < cnt; j++) {
                sb.append((char) ints[1]);
            }
        }
        return sb.toString();
    }
}
