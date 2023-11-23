package leetcode.problems;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2023/11/23 18:43
 */
public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        res.append(sign);

        long num = Math.abs((long) numerator);
        long ldenominator = Math.abs((long) denominator);

        res.append(num / ldenominator);
        num %= ldenominator;

        if (num == 0) {
            return res.toString();
        }

        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        // 除法过程
        while (num != 0) {
            num *= 10;
            res.append(num / ldenominator);
            num %= ldenominator;
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
