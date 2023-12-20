package basic.algorithm.bit;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 01:29
 * @see leetcode.problems.LeetCode191 位1的个数
 * @see leetcode.problems.LeetCode231
 * @see leetcode.problems.LeetCode260
 * @see leetcode.problems.LeetCode762
 * @see leetcode.problems.LeetCode405
 * @see leetcode.problems.LeetCode371  两整数之和
 */
public interface BIT {

    /*
     * 取最后一个 1
     *  (n & -n)
     *
     * 将 n 二进制表示的最低位 1 移除
     * n & (n - 1)
     *
     * 末尾是否为 1
     * (n & 1) == 1
     *
     * >> arithmetic shift
     * >>> logic shift
     * */
}
