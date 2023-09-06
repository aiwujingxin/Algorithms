package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 21:47
 */
public class LeetCode1764 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1764().canChoose(new int[][]{{1, -1, -1}, {3, -2, 0}}, new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0}));
    }

    public boolean canChoose(int[][] gs, int[] nums) {
        int index = 0;
        for (int[] g : gs) {
            int j = 0;
            while (j < g.length && index < nums.length) {
                if (g[j] == nums[index]) {
                    j++;
                    index++;
                } else {
                    index = index - j + 1;
                    j = 0;
                }
            }
            if (index >= nums.length && j != g.length) {
                return false;
            }
        }
        return true;
    }
}
