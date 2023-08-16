package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-12-21 8:38 PM
 */
public class LeetCode274 {


    public static void main(String[] args) {
        System.out.println(new LeetCode274().hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    //计数排序
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;

        // 有counter[i]篇被引用了i次
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                //有h篇被引用了h次
                return i;
            }
        }
        return 0;
    }


    //排序
    public int hIndexV2(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }


    //二分
    public int hIndexV3(int[] citations) {
        int lo = 1, hi = 1000, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid, citations)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int v, int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= v) {
                cnt++;
            }
        }
        return cnt >= v;
    }
}
