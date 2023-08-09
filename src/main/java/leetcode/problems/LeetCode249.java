package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 17:48
 */
public class LeetCode249 {

    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                sb.append("#");
                int shift = (c - str.charAt(0) + 26) % 26;
                sb.append(shift);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    //===OPT==
    public List<List<String>> groupStrings_opt(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        int i;
        for (i = 0; i < strings.length; i++) {
            String str = strings[i];
            char[] ch = str.toCharArray();
            if (ch.length != 0) {
                int offset = ch[0] - 'a';
                for (int j = 0; j < ch.length; j++) {
                    ch[j] -= offset;
                    if (ch[j] < 'a') {
                        ch[j] += 26;
                    }
                }
            }
            String norStr = new String(ch);
            List<String> l = map.getOrDefault(norStr, new ArrayList<>());
            l.add(str);
            map.put(norStr, l);
        }
        return new ArrayList<>(map.values());
    }
}
