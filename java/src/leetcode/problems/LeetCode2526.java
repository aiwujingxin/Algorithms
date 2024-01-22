package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 15:37
 */
public class LeetCode2526 {

    class DataStream {

        int cnt = 0;
        int value;
        int k;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            if (num == value) {
                cnt++;
            } else {
                cnt = 0;
            }
            return cnt >= k;
        }
    }
}
