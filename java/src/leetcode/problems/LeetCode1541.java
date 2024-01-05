package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 12:37
 * @description 贪心 到了不得不做的时候才做，这个时候就是最优解
 * @see LeetCode921
 */
public class LeetCode1541 {

    public int minInsertions(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                // 匹配
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    res++; // 加一个右括号
                }
                count--;
            }
            if (count < 0) { //右括号太多了，必须补充一个左括号
                res++;
                count = 0;
            }
        }
        return res + count * 2;
    }
}
