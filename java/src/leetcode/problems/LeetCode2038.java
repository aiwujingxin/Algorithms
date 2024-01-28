package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 20:03
 */
public class LeetCode2038 {

    // 计数
    // 统计 A 可以操作几次。B可以操作几次。A 的次数要大与 B 的次数
    public boolean winnerOfGame(String colors) {
        int A = cal(colors, 'A');
        int B = cal(colors, 'B');
        if (A == 0) {
            return false;
        }
        return A > B;
    }

    private int cal(String colors, char c) {
        int index = 0;
        int res = 0;
        int n = colors.length();
        while (index < n) {
            while (index < n && colors.charAt(index) != c) {
                index++;
            }
            if (index == n) {
                return res;
            }
            int t = index;
            while (t < n && colors.charAt(t) == c) {
                t++;
            }
            res += Math.max(0, t - index - 2);
            index = t;
        }
        return res;
    }
}
