package knowledge.algorithms.bitwise;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 01:29
 * @description 位运算
 * @see leetcode.problems.LeetCode191 位1的个数
 * @see leetcode.problems.LeetCode231
 * @see leetcode.problems.LeetCode260
 * @see leetcode.problems.LeetCode762
 * @see leetcode.problems.LeetCode405
 * @see leetcode.problems.LeetCode371  两整数之和
 * @see leetcode.problems.LeetCode136 136. 只出现一次的数字
 * @see leetcode.problems.LeetCode137 137. 只出现一次的数字 II
 */
public interface BIT {

    /*
     * 取最后一个 1
     *  (n & -n)
     *
     * 将 n 二进制表示的最低位 1 移除
     * n -= (n & -n)
     *
     * 末尾是否为 1
     * (n & 1) == 1
     *
     * 枚举子集
     * for(subset = (A - 1) & A; subset != A; subset = (subset - 1) & A) {...}
     *
     *
     * arithmetic shift
     * >>
     * logic shift
     * >>>
     * */
}
