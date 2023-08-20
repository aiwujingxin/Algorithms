package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-18 10:21 PM
 */
public class LeetCode621 {

    //https://www.jiakaobo.com/leetcode/621.%20Task%20Scheduler.html
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
