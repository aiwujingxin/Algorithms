package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 11/24/25 15:25
 */
public class LeetCode3020 {

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        int max = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            max = Math.max(max, num);
        }
        if (map.containsKey(1)) {
            int cnt = map.get(1);
            if (cnt % 2 == 0) {
                res = Math.max(res, cnt - 1);
            } else {
                res = Math.max(res, cnt);
            }
        }
        for (int num : map.keySet()) {
            if (num == 1 || num * num > max) continue;
            int cnt = 0;
            int t = num;
            while (map.getOrDefault(t, 0) >= 2) {
                cnt += 2;
                t *= t;
            }
            if (map.containsKey(t)) {
                cnt++;
            } else {
                cnt--;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}

