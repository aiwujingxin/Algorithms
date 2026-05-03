package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:32
 */
public class LeetCode12 {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] signs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < signs.length; i++) {
            int t = num / values[i];
            if (t > 0) {
                sb.repeat(signs[i], t);
                num -= t * values[i];
            }
            if (num == 0) break;
        }
        return sb.toString();
    }

    class Solution_OPT {
        // 意图：将有限状态空间直接物理固化为内存表，彻底消灭循环和分支
        private static final String[] THOUSANDS = {"", "M", "MM", "MMM"};
        private static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        private static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        private static final String[] ONES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        public String intToRoman(int num) {
            // 循环不变量：无。直接 O(1) 物理寻址。
            return THOUSANDS[num / 1000] + HUNDREDS[(num % 1000) / 100] + TENS[(num % 100) / 10] + ONES[num % 10];
        }
    }
}
