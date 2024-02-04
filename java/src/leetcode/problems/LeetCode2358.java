package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 10:45
 */
public class LeetCode2358 {

    public int maximumGroups(int[] grades) {
        if (grades == null || grades.length == 0) {
            return 0;
        }
        int n = grades.length;
        int res = 0;
        int cnt = 1;
        int index = 0;
        while (index < n) {
            if (index + cnt > n) {
                break;
            }
            index = index + cnt;
            res++;
            cnt++;
        }
        return res;
    }
}
