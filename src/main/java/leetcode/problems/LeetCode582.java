package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 17:14
 */
public class LeetCode582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            Integer parent = ppid.get(i);
            if (parent > 0) {
                List<Integer> chs = map.getOrDefault(parent, new ArrayList<>());
                chs.add(pid.get(i));
                map.put(parent, chs);
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(kill);
        dfs(map, kill, list);
        return list;
    }

    private void dfs(HashMap<Integer, List<Integer>> map, int kill, List<Integer> list) {
        if (map.containsKey(kill)) {
            for (int i = 0; i < map.get(kill).size(); i++) {
                list.add(map.get(kill).get(i));
                dfs(map, map.get(kill).get(i), list);
            }
        }
    }
}
