package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 16:05
 * @description 埃氏筛 O(nloglogn)
 */
public class LeetCode204 {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                cnt++;
                for (int j = i * 2; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return cnt;
    }
}
