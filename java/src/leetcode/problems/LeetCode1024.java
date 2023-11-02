package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 00:38
 */
public class LeetCode1024 {

    //https://leetcode.cn/problems/video-stitching/solutions/1743182/by-alexshwing-gpf5/

    public int videoStitching(int[][] clips, int time) {
        int[] nums = new int[time];
        for (int[] clip : clips) {
            int l = clip[0];
            int r = clip[1];
            if (l < time) {
                nums[l] = Math.max(nums[l], r - l);
            }
        }
        int step = 0;
        int max = 0; // 下一次可以跳的最远位置
        int cur = 0; // 本次可以跳的最远位置
        for (int i = 0; i < time; i++) {
            if (i > cur) {
                return -1; // 无法跳跃
            }
            max = Math.max(max, i + nums[i]);
            if (i == cur) {
                cur = max;
                step++;
            }
        }
        if (cur >= time) {
            return step;
        }
        return -1; // 无法跳到终点
    }
}
