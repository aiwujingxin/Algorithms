package leetcode.lists.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 21:10
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String key = new String(tempArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            result.add(m.getValue());
        }
        return result;
    }
}
