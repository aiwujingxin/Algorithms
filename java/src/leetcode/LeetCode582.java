package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 17:14
 */
public class LeetCode582 {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    List<Integer> list = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < pid.size(); i++) {
            Integer parent = ppid.get(i);
            if (parent > 0) {
                List<Integer> chs = map.getOrDefault(parent, new ArrayList<>());
                chs.add(pid.get(i));
                map.put(parent, chs);
            }
        }
        list.add(kill);
        dfs(kill);
        return list;
    }

    private void dfs(int kill) {
        if (map.containsKey(kill)) {
            for (int next : map.get(kill)) {
                list.add(next);
                dfs(next);
            }
        }
    }
}
