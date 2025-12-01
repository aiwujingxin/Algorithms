package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 11/17/25 17:20
 * @description 如果某个状态在当前位置本应是“不存在的”（也就是从开头到当前位置没有任何以该 parity 结尾的合法路径），
 * 你不能把它设为 0。因为 0 会被当成“存在且得分为 0”的合法路径，进而参与后续的 max(...) 计算，产生假的可达路径并影响结果。
 * <p>
 * 不可达状态 ≠ 0，不能随便当作 0，否则后续转移会污染答案。
 * 安全的极小值：Long.MIN_VALUE / 4 或足够小的负数，避免溢出。
 */
public class LeetCode2786 {

    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[] dpOdd = new long[n];
        long[] dpEven = new long[n];
        dpEven[0] = nums[0] % 2 == 0 ? nums[0] : Long.MIN_VALUE / 2;
        dpOdd[0] = nums[0] % 2 == 1 ? nums[0] : Long.MIN_VALUE / 2;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 1) {
                dpOdd[i] = Math.max(dpOdd[i - 1] + nums[i], dpEven[i - 1] - x + nums[i]);
                dpEven[i] = dpEven[i - 1];
            } else {
                dpEven[i] = Math.max(dpEven[i - 1] + nums[i], dpOdd[i - 1] - x + nums[i]);
                dpOdd[i] = dpOdd[i - 1];
            }
        }
        return Math.max(dpEven[n - 1], dpOdd[n - 1]);
    }
}
