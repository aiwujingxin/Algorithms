package leetcode.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 01:14
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> set = new ArrayList<>();
                set.add(str);
                map.put(key, set);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(new ArrayList<>(entry.getValue()));
        }
        return res;
    }
}
