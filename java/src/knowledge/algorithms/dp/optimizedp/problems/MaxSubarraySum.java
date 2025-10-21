package knowledge.algorithms.dp.optimizedp.problems;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 22:29
 * @description 最大子序和
 */
public class MaxSubarraySum {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedInputStream(System.in));
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            long ans = maxSubarraySumAtMostM(nums, m);
            System.out.println(ans);
        }

        // 返回长度 <= m 的连续子序列的最大和（长度至少 1）
        public static long maxSubarraySumAtMostM(int[] nums, int m) {
            int n = nums.length;
            long[] s = new long[n + 1];
            for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
            long res = Long.MIN_VALUE;
            Deque<Integer> dq = new ArrayDeque<>();
            dq.addLast(0); // 存前缀和的下标，初始 s[0] = 0
            for (int i = 1; i <= n; i++) {
                // 1) 维护队头有效（满足 i - start <= m）
                while (!dq.isEmpty() && i - dq.peekFirst() > m) dq.pollFirst();
                // 2) 用队头（窗口内最小前缀和）更新答案
                if (!dq.isEmpty()) res = Math.max(res, s[i] - s[dq.peekFirst()]);
                // 3) 维护队尾单调性（s[index] 单调递增）
                while (!dq.isEmpty() && s[dq.peekLast()] >= s[i]) dq.pollLast();
                dq.addLast(i);
            }
            return res;
        }
    }
}
