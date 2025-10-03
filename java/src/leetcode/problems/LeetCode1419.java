package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/2/25 11:46
 */
public class LeetCode1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] len = new int[6];
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if (croakOfFrogs.charAt(i) == 'c') {
                if (len[5] > 0) {
                    len[5]--;
                }
                len[1]++;
            }
            if (croakOfFrogs.charAt(i) == 'r') {
                if (len[1] <= 0) {
                    return -1;
                }
                len[1]--;
                len[2]++;
            }
            if (croakOfFrogs.charAt(i) == 'o') {
                if (len[2] <= 0) {
                    return -1;
                }
                len[2]--;
                len[3]++;
            }
            if (croakOfFrogs.charAt(i) == 'a') {
                if (len[3] <= 0) {
                    return -1;
                }
                len[3]--;
                len[4]++;
            }
            if (croakOfFrogs.charAt(i) == 'k') {
                if (len[4] <= 0) {
                    return -1;
                }
                len[4]--;
                len[5]++;
            }
        }
        if (len[1] != 0 || len[2] != 0 || len[3] != 0 || len[4] != 0) {
            return -1;
        }
        return len[5];
    }
}
