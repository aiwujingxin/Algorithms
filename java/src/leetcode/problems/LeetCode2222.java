package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:13
 */
public class LeetCode2222 {

    public long numberOfWays(String s) {
        long[] dp010 = new long[4], dp101 = new long[4];
        dp010[0] = 1; // 空前缀，匹配长度 0
        dp101[0] = 1;

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                dp010[1] += dp010[0]; // 模式 010 的第一个 0
                dp010[3] += dp010[2]; // 模式 010 的最后一个 0
                dp101[2] += dp101[1]; // 模式 101 的中间 0
            } else { // ch == '1'
                dp010[2] += dp010[1]; // 模式 010 的中间 1
                dp101[1] += dp101[0]; // 模式 101 的第一个 1
                dp101[3] += dp101[2]; // 模式 101 的最后一个 1
            }
        }
        return dp010[3] + dp101[3];
    }
}
