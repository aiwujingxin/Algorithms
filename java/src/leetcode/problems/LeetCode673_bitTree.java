package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 13:34
 */
public class LeetCode673_bitTree {

    int n;
    int[][] tree = new int[2010][2];

    public int findNumberOfLIS(int[] nums) {
        this.n = nums.length;
        // 离散化
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : set) {
            map.put(num, rank++);
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


    int[] query(int x) {
        int len = 0, cnt = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            if (len == tree[i][0]) {
                cnt += tree[i][1];
            } else if (len < tree[i][0]) {
                len = tree[i][0];
                cnt = tree[i][1];
            }
        }
        return new int[]{len, cnt};
    }

    void add(int x, int[] info) {
        for (int i = x; i <= n; i += lowbit(i)) {
            int len = tree[i][0], cnt = tree[i][1];
            if (len == info[0]) {
                cnt += info[1];
            } else if (len < info[0]) {
                len = info[0];
                cnt = info[1];
            }
            tree[i][0] = len;
            tree[i][1] = cnt;
        }
    }

    int lowbit(int x) {
        return x & -x;
    }
}
