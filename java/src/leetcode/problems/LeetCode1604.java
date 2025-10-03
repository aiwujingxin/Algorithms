package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 18:23
 */
public class LeetCode1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            map.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(getTime(keyTime[i]));
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 3600) {
                    names.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(names);
        return names;
    }

    private Integer getTime(String s) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0]) * 3600 + Integer.parseInt(ss[1]) * 60;
    }
}
