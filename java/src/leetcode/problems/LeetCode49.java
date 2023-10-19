package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 14:54
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = new String(chars);
            if (!map.containsKey(s1)) {
                map.put(s1, new ArrayList<>());
            }
            map.get(s1).add(s);
        }
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrys : map.entrySet()) {
            list.add(entrys.getValue());
        }
        return list;
    }
}
