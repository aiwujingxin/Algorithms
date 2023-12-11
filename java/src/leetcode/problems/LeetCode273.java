package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/26 14:04
 */
public class LeetCode273 {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1_000_000_000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuilder curr = new StringBuilder();
                dfs(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    public void dfs(StringBuilder sb, int num) {
        if (num == 0) {
            return;
        }
        if (num < 10) {
            sb.append(singles[num]).append(" ");
        } else if (num < 20) {
            sb.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            sb.append(tens[num / 10]).append(" ");
            dfs(sb, num % 10);
        } else {
            sb.append(singles[num / 100]).append(" Hundred ");
            dfs(sb, num % 100);
        }
    }
}
