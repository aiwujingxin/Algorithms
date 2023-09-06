package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 22:05
 */
public class LeetCode1764_kmp {

    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for (int i = 0; i < groups.length; i++) {
            int j = 0;
            int[] next = makePrefix(groups[i]);
            while (j < groups[i].length && index < nums.length) {
                if (groups[i][j] == nums[index]) {
                    index++;
                    j++;
                } else if (j != 0) {
                    j = next[j - 1];
                } else {
                    index++;
                }
            }
            if (i == groups.length - 1 && j == groups[i].length) {
                return true;
            }
        }
        return false;
    }

    public int[] makePrefix(int[] nums) {
        int[] prefix = new int[nums.length];
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                prefix[j] = i + 1;
                i++;
                j++;
            } else {
                if (i - 1 >= 0) {
                    i = prefix[i - 1];
                } else {
                    prefix[j++] = 0;
                }
            }
        }
        return prefix;
    }
}
