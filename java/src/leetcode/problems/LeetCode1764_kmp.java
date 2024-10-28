package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 22:05
 */
public class LeetCode1764_kmp {

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; k < groups.length; k++) {
            int j = 0;
            int[] ne = next(groups[k]);
            while (j < groups[k].length && i < nums.length) {
                if (groups[k][j] == nums[i]) {
                    i++;
                    j++;
                } else if (j != 0) {
                    j = ne[j];
                } else {
                    i++;
                }
            }
            if (k == groups.length - 1 && j == groups[k].length) {
                return true;
            }
        }
        return false;
    }

    public int[] next(int[] pattern) {
        int m = pattern.length;
        int[] p = new int[m + 1]; // Pattern string
        int[] ne = new int[m + 1];
        for (int i = 0; i < m; i++) p[i + 1] = pattern[i];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        return ne;
    }
}
