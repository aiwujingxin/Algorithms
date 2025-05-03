package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:30
 */
public class LeetCode954 {

    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int a : arr) {
            int t = a * 2;
            if (map.getOrDefault(a, 0) == 0) {
                continue;
            }
            if ((t == a && map.getOrDefault(t, 0) > 1) || (t != a && map.getOrDefault(t, 0) > 0)) {
                cnt++;
                map.put(t, map.getOrDefault(t, 0) - 1);
                map.put(a, map.getOrDefault(a, 0) - 1);
            }
        }
        return cnt == arr.length / 2;
    }
}
