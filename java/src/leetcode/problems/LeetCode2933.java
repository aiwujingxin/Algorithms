package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2/15/25 13:14
 */
public class LeetCode2933 {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, List<Integer>> timeMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (List<String> visit : access_times) {
            String name = visit.get(0);
            int time = (visit.get(1).charAt(0) * 10 + visit.get(1).charAt(1)) * 60 + visit.get(1).charAt(2) * 10 + visit.get(1).charAt(3);
            List<Integer> list = timeMap.getOrDefault(name, new ArrayList<>());
            list.add(time);
            timeMap.put(name, list);
        }

        for (Map.Entry<String, List<Integer>> entry : timeMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 3) {
                continue;
            }
            Collections.sort(list);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) < 60) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        return result;
    }
}
