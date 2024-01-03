package basic.datastructure.string;

import basic.datastructure.string.impl.InfixToSuffix;
import leetcode.lists.classic.Classic0814;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 11:54
 * 高精度
 * @see LeetCode415 加
 * @see LeetCode43 乘
 * 计算
 * @see InfixToSuffix 中缀转后缀
 * @see LeetCode150 逆波兰表达式求值 ["2","1","+","3","*"] => ((2 + 1) * 3) = 9
 * @see .LeetCode227 基本计算器 II " 3+5 / 2 "
 * @see LeetCode224 基本计算器 "(1+(4+5+2)-3)+(6+8)"
 * @see LeetCode772 基本计算器 III  "2*(5+5*2)/3+(6/2+8)"
 * @see LeetCode241 为运算表达式设计优先级
 * 转义数字
 * @see LeetCode8 8. 字符串转换整数 (atoi)
 * @see LeetCode273 273. 整数转换英文表示
 * @see LeetCode12 12. 整数转罗马数字
 * @see LeetCode13 13. 罗马数字转整数
 * 其他解析
 * @see LeetCode93 93. 复原 IP 地址
 * @see LeetCode439 439. 三元表达式解析器
 * @see Classic0814 布尔运算
 * @see LeetCode7 整数反转
 * 1106. 解析布尔表达式
 */
public interface Parser {
    String addStrings(String s1, String s2);

    String subtract(String s1, String s2);

    String multiply(String s1, String s2);

    String divide(String s1, int s2);
}
