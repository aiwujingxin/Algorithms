package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 03:00
 */
public class LeetCode3265 {

    int[][] freq;
    String[] strs;

    public int countPairs(int[] nums) {
        int n = nums.length;
        freq = new int[n][10];
        strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            for (char c : strs[i].toCharArray()) {
                freq[i][c - '0']++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean check(int i, int j) {
        String a = strs[i];
        String b = strs[j];
        int f = 0;
        for (int k = 1; k < 10; k++) {
            f += Math.abs(freq[i][k] - freq[j][k]);
        }
        if (f != 0) {
            return false;
        }
        int len = Math.abs(a.length() - b.length());
        if (a.length() < b.length()) {
            a = "0".repeat(len) + a;
        } else {
            b = "0".repeat(len) + b;
        }
        int n = a.length();
        int diff = 0;
        for (int k = 0; k < n; k++) {
            if (a.charAt(k) != b.charAt(k)) {
                diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
}
