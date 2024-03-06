package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 18:23
 */
public class LeetCode1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> times = map.getOrDefault(keyName[i], new ArrayList<>());
            times.add(getTime(keyTime[i]));
            map.put(keyName[i], times);
        }
        List<String> names = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> times = entry.getValue();
            times.sort(Comparator.comparingInt(o -> o));
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 3600 && times.get(i) - times.get(i - 2) >= 0) {
                    names.add(entry.getKey());
                    break;
                }
            }
        }
        names.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        return names;

    }

    private Integer getTime(String s) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0]) * 3600 + Integer.parseInt(ss[1]) * 60;
    }
}
