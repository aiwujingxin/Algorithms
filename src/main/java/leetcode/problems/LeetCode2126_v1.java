package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 23:34
 */
public class LeetCode2126_v1 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        //根据数据范围，最多不超过17位
        long[] sum = new long[17];
        int[] min = new int[17];
        for (int asteroid : asteroids) {
            int h = getH(asteroid);
            if (asteroid < min[h] || min[h] == 0) {
                min[h] = asteroid;
            }
            sum[h] += asteroid;
        }
        long cur = mass;
        for (int i = 0; i < 17; i++) {
            if (cur >= min[i]) {
                cur += sum[i];
            } else {
                return false;
            }
        }
        return true;
    }
    //获得二进制有几位，从0开始
    public int getH(int x) {
        int cnt = 0;
        while (x != 1) {
            x >>= 1;
            cnt++;
        }
        return cnt;
    }

}
