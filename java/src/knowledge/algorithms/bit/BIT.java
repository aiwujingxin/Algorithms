package knowledge.algorithms.bit;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 01:29
 * @description 位运算
 * @see knowledge.datastructure.adv.BITree    树状数组
 * @see knowledge.algorithms.dp.compressdp    状压DP
 * @see leetcode.problems.LeetCode67  二进制求和
 * @see leetcode.problems.LeetCode136 只出现一次的数字
 * @see leetcode.problems.LeetCode137 只出现一次的数字II
 * @see leetcode.problems.LeetCode191 位1的个数
 * @see leetcode.problems.LeetCode231
 * @see leetcode.problems.LeetCode260
 * @see leetcode.problems.LeetCode371 两整数之和
 * @see leetcode.problems.LeetCode405
 * @see leetcode.problems.LeetCode762
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
     * arithmetic shift
     * >>
     * logic shift
     * >>>
     * */
}
