package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 19:12
 */
public class LeetCode12 {

    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] units = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = values.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (num / values[i] > 0) {
                sb.append(units[i]);
                num = num - values[i];
            }
        }
        return sb.toString();
    }
}
