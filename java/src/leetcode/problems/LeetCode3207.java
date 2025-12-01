package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 11/20/25 16:56
 */
public class LeetCode3207 {

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long ans = 0;
        long lcurrentEnergy = currentEnergy;
        Arrays.sort(enemyEnergies);
        int n = enemyEnergies.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            while (lcurrentEnergy >= enemyEnergies[i]) {
                long times = lcurrentEnergy % enemyEnergies[i];
                ans += times;
                lcurrentEnergy -= enemyEnergies[i] * times;
            }
            if (ans >= 1) {
                lcurrentEnergy += enemyEnergies[j];
                j--;
            } else {
                break;
            }
        }
        return ans;
    }
}
