package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 12:04
 */
public class LeetCode2522 {

    public int minimumPartition(String s, int k) {
        int cnt = 0;
        int n = s.length();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if (num > k) {
                return -1;
            }
            sum = sum * 10 + num;
            if (sum > k) {
                cnt++;
                sum = num;
            }
        }
        return cnt + 1;
    }
}
