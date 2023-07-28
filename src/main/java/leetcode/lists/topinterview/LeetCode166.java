package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/26 22:29
 */
public class LeetCode166 {
    //https://www.jiakaobo.com/leetcode/166.%20Fraction%20to%20Recurring%20Decimal.html

    public static void main(String[] args) {
        System.out.println(new LeetCode166().fractionToDecimal(4, 333));
    }

    //study
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        res.append(sign);

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append(num / den);
        num %= den;

        if (num == 0) {
            return res.toString();
        }

        res.append(".");

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {
            // 除法过程
            num *= 10;
            res.append(num / den);
            num %= den; // 余数
            if (map.containsKey(num)) { //余数重复出现,表示找到循环的起点
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
