package knowledge.datastructure.string.bignumber;

import leetcode.problems.LeetCode29;
import leetcode.problems.LeetCode415;
import leetcode.problems.LeetCode43;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 13:23
 * @see LeetCode415 加
 * @see LeetCode43 乘
 * @see LeetCode29 除
 */
public interface BigDecimal {

    String addStrings(String s1, String s2);

    String subtract(String s1, String s2);

    String multiply(String s1, String s2);

    String divide(String s1, int s2);
}
