package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/25 10:16
 */
public class LeetCode833 {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < sources.length; j++) {
            int index = s.indexOf(sources[j], indices[j]);
            if (index != -1 && index == indices[j]) {
                set.add(index);
                map.put(index, j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (!set.contains(index)) {
                sb.append(s.charAt(index));
                index++;
            } else {
                sb.append(targets[map.get(index)]);
                index += sources[map.get(index)].length();
            }
        }
        return sb.toString();
    }
}

