package leetcode.problems;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 11/16/25 15:49
 */
public class LeetCode3499 {


    public int maxActiveSectionsAfterTrade(String s) {
        int total = cal(s);
        String ss = "1" + s + "1";
        int[] right = new int[ss.length()];
        Arrays.fill(right, -1);
        int pre0 = ss.charAt(ss.length() - 1) == '0' ? ss.length() - 1 : -1;
        for (int i = ss.length() - 1; i >= 0; i--) {
            if (ss.charAt(i) == '1') {
                right[i] = pre0;
            }
            if (ss.charAt(i) == '0' && (ss.charAt(i + 1) == '1' || pre0 == -1)) {
                pre0 = i;
            }
        }
        int[] presum = new int[ss.length() + 1];
        for (int i = 1; i <= ss.length(); i++) {
            presum[i] = presum[i - 1] + (ss.charAt(i - 1) - '0');
        }
        int[] left = new int[ss.length()];
        Arrays.fill(left, -1);
        pre0 = ss.charAt(0) == '0' ? 0 : -1;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == '1') {
                left[i] = pre0;
            }
            if (ss.charAt(i) == '0' && (ss.charAt(i - 1) == '1' || pre0 == -1)) {
                pre0 = i;
            }
        }
        int max = total;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == '1') {
                int l0 = left[i];
                int r0 = right[i];
                if (l0 == -1 || r0 == -1)
                    continue;
                int len = r0 - l0 + 1;
                int cnt1 = presum[r0 + 1] - presum[l0];
                int add = len - cnt1;
                max = Math.max(max, total + add);
            }
        }
        return max;
    }

    public int cal(String nums) {
        int cnt = 0;
        for (char num : nums.toCharArray()) {
            cnt += num - '0';
        }
        return cnt;
    }

}
