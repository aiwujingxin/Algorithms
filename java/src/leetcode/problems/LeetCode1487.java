package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 13:12
 */
public class LeetCode1487 {

    public String[] getFolderNames(String[] names) {
        int n = names.length;
        HashMap<String, Integer> map = new HashMap<>();
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 0);
            } else {
                String preName = name;
                while (map.containsKey(name)) {
                    int pi = map.getOrDefault(preName, 0) + 1;
                    while (map.containsKey(preName + "(" + pi + ")")) {
                        pi++;
                    }
                    preName = name;
                    name += "(" + pi + ")";
                }
                res[i] = name;
                map.put(preName, map.getOrDefault(preName, -1) + 1);
                map.put(name, map.getOrDefault(name, -1) + 1);
            }
        }
        return res;
    }

}
