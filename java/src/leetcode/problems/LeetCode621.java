package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 22:49
 */
public class LeetCode621 {
    //https://www.youtube.com/watch?v=siNqiP6tk94&t=302s
    // 1) 关键是最多的任务 2) 最多的任务有几个?maxCountSame个
    // A _ _ _ _ _ A _ _ _ _ _ A....
    // (n+1)*(maxCount - 1) + maxCountSame
    // 3) 比较 整个长度
    public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for (char task : tasks) {
            dict[task - 'A']++;
        }
        int maxCount = 0;
        int maxCountSame = 0;
        for (int num : dict) {
            if (num > maxCount) {
                maxCount = num;
                maxCountSame = 1;
            } else if (num == maxCount) {
                maxCountSame++;
            }
        }
        int res = (maxCount - 1) * (n + 1) + maxCountSame;
        return Math.max(res, tasks.length);
    }

}
