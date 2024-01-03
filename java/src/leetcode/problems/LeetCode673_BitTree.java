package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 13:34
 */
public class LeetCode673_BitTree {

    int n;
    int[][] tr = new int[2010][2];

    int lowbit(int x) {
        return x & -x;
    }

    int[] query(int x) {
        int len = 0, cnt = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            if (len == tr[i][0]) {
                cnt += tr[i][1];
            } else if (len < tr[i][0]) {
                len = tr[i][0];
                cnt = tr[i][1];
            }
        }
        return new int[]{len, cnt};
    }

    void add(int x, int[] info) {
        for (int i = x; i <= n; i += lowbit(i)) {
            int len = tr[i][0], cnt = tr[i][1];
            if (len == info[0]) {
                cnt += info[1];
            } else if (len < info[0]) {
                len = info[0];
                cnt = info[1];
            }
            tr[i][0] = len;
            tr[i][1] = cnt;
        }
    }

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;
        // 离散化
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, idx = 1; i < n; i++) {
            if (!map.containsKey(tmp[i])) {
                map.put(tmp[i], idx++);
            }
        }
        // 树状数组维护 (len, cnt) 信息
        for (int i = 0; i < n; i++) {
            int x = map.get(nums[i]);
            int[] info = query(x - 1);
            int len = info[0], cnt = info[1];
            add(x, new int[]{len + 1, Math.max(cnt, 1)});
        }
        int[] ans = query(n);
        return ans[1];
    }
}
