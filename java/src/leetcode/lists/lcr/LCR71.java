package leetcode.lists.lcr;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:15
 */
public class LCR71 {


    static class Solution {

        public static void main(String[] args) {
            Solution s = new Solution(new int[]{3, 14, 1, 7});
            System.out.println();

            for (int i = 0; i < 100; i++) {
                int rand = new Random().nextInt(3) + 1;
                System.out.println(rand);
            }
        }

        int[] presum;

        public Solution(int[] w) {
            presum = new int[w.length];
            presum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                presum[i] = presum[i - 1] + w[i];
            }
            System.out.println(Arrays.toString(presum));
        }

        //拉平去看
        //第一个大于等于
        public int pickIndex() {
            // 介于 0(包括) 和 最大值（presum[presum.length - 1]）
            // +1 生成 [1, max] 之间的随机数
            int rand = new Random().nextInt(presum[presum.length - 1]) + 1;
            int left = 0;
            int right = presum.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (presum[mid] < rand) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
