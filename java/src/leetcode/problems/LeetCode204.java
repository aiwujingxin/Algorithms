package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 16:05
 * @description 埃氏筛 O(nloglogn)
 */
public class LeetCode204 {

    public int countPrimes(int n) {
        boolean[] visit = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!visit[i])
                for (int j = i * i; j < n; j += i)
                    visit[j] = true;
        }
        int k = 0;
        for (int i = 2; i < n; i++) {
            if (!visit[i]) k++;
        }
        return k;
    }
}
