package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/24 22:50
 */
public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0) {
            return "0";
        }
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        long lnumerator = Math.abs((long) numerator);
        long ldenominator = Math.abs((long) denominator);

        sb.append(sign);
        if (lnumerator % ldenominator == 0) {
            sb.append(lnumerator / ldenominator);
            return sb.toString();
        }

        sb.append(lnumerator / ldenominator);
        sb.append(".");
        lnumerator = lnumerator % ldenominator;

        HashMap<Long, Integer> map = new HashMap<>();
        while (lnumerator > 0) {
            lnumerator = lnumerator * 10;
            long t = lnumerator / ldenominator;
            lnumerator = lnumerator % ldenominator;
            if (!map.containsKey(lnumerator)) {
                sb.append(t);
                map.put(lnumerator, sb.length());
            } else {
                sb.insert(map.get(lnumerator), "(");
                sb.append(t);
                sb.append(")");
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
