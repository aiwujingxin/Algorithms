package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 17:27
 */
public class LeetCode2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        char[] cars = new char[]{'M', 'P', 'G'};
        int res = 0;
        int[][] freq = new int[garbage.length][26];
        int[] presum = new int[travel.length + 1];
        for (int i = 1; i <= travel.length; i++) {
            presum[i] = presum[i - 1] + travel[i - 1];
        }
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                freq[i][garbage[i].charAt(j) - 'A']++;
            }
        }
        for (char car : cars) {
            int cost = 0;
            int max = 0;
            for (int j = 0; j < garbage.length; j++) {
                int cnt = freq[j][car - 'A'];
                cost += cnt;
                if (cnt > 0) {
                    max = j;
                }
            }
            res += cost + presum[max];
        }
        return res;
    }
}
