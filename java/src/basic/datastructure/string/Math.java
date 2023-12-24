package basic.datastructure.string;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 11:54
 * 高精度计算
 * @see leetcode.problems.LeetCode415 加
 * @see leetcode.problems.LeetCode43 乘
 * 计算器
 * @see leetcode.problems.LeetCode227 基本计算器 II https://leetcode.cn/problems/basic-calculator-ii/ " 3+5 / 2 "
 * @see leetcode.problems.LeetCode224 基本计算器 https://leetcode.cn/problems/basic-calculator/  "(1+(4+5+2)-3)+(6+8)"
 * @see leetcode.problems.LeetCode772 基本计算器 III https://leetcode.cn/problems/basic-calculator-iii/ "2*(5+5*2)/3+(6/2+8)"
 * 转义数字
 * @see leetcode.problems.LeetCode273
 * @see leetcode.problems.LeetCode12
 * @see leetcode.problems.LeetCode13
 */
public interface Math {
    String addStrings(String s1, String s2);

    String subtract(String s1, String s2);

    String multiply(String s1, String s2);

    String divide(String s1, int s2);
}
