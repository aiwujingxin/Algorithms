package knowledge.mathematics.bigdecimal.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 分数转小数 (检测并标注循环节)
 * <适用场景>
 * 给定分子分母，输出精确的十进制表示；无限循环时用括号标出循环节 (LeetCode 166)。
 * <核心思想>
 * 整数部分直接相除；小数部分模拟竖式除法，每次余数乘 10 再除。
 * 用哈希表记录每个余数首次出现的位置，一旦余数重复即找到循环起点。
 */
public class RepeatingDecimal {

    public static String fractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();
        // 符号
        if ((numerator < 0) ^ (denominator < 0)) result.append('-');
        long num = Math.abs(numerator);
        long den = Math.abs(denominator);
        // 整数部分
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString();
        result.append('.');
        // 小数部分：余数 -> 结果位置
        Map<Long, Integer> seen = new HashMap<>();
        while (remainder != 0) {
            if (seen.containsKey(remainder)) {
                int start = seen.get(remainder);
                result.insert(start, '(');
                result.append(')');
                break;
            }
            seen.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        return result.toString();
    }
}
