package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 22:40
 */
public class LeetCode239_sd {
    
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] q = new int[n];
        int[] res = new int[n - k + 1];
        int hh = 0, tt = -1;//重新赋值
        for (int i = 0; i < n; i++) {
            //判断队列是否是空的
            //因为滑动窗口k有范围限制，如果你的队头滑出窗口，就要把队头往后移动到下一位，将队头去掉
            if (hh <= tt && q[hh] < i - k + 1) {
                hh++;
            }
            //判断队列是否是空的
            //如果队尾元素小于等于我要插入的数，因为是要求滑动窗口中的最大值，
            //所以前面比较小的数不会被用到，所以要删除，将队尾删除 (tt--);
            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }
            //将新插入的数的下标插入到队列中(队列中存的是输入的数的下标)
            q[++tt] = i;
            //因为滑动窗口有范围限制，所以要保证插入的数大于等于k是才开始输出
            if (i >= k - 1) {
                res[i - k + 1] = a[q[hh]];
            }
        }
        return res;
    }
}
