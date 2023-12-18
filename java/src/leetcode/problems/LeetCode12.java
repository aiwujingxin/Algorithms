package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 20:23
 */
public class LeetCode12 {

    public String intToRoman(int num) {
        if (num == 0) {
            return "0";
        }
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();

    }
}
