package leetcode.problems;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 12/12/25 14:05
 */
public class LeetCode2171 {


    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long[] sum = new long[n + 1];
        for (int i = 1; i <= beans.length; i++) {
            sum[i] = sum[i - 1] + beans[i - 1];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long t = sum[i - 1 + 1] - sum[0] + (sum[n] - sum[i] - (long) beans[i] * (n - i));
            if (t <0) continue;
            min = Math.min(min, t);
        }
        return min;
    }
    public long minimumRemoval_(int[] beans) {
        int max = 0;
        int n = beans.length;
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
            max = Math.max(max, bean);
        }
        Arrays.sort(beans);
        int avg = (int) sum / n;
        long l = findL(beans, avg);
        long r = findR(beans, avg);
        long s1 = cal(beans, l);
        long s2 = cal(beans, r);
        return Math.min(s1, s2);
    }

    private long cal(int[] beans, long t) {
        long sum = 0;
        for (int bean : beans) {
            if (bean <= t) {
                sum += bean;
            } else {
                sum += bean - t;
            }
        }
        return sum;
    }

    //    // 保留 越多越好
//    private long cal1(int[] beans, int l, int r) {
//        while (l < r) {
//            int mid = l + r + 1 >> 1;
//            if (check1(beans, mid)) l = mid;
//            r = mid - 1;
//        }
//        long sum = 0;
//        for (int bean : beans) {
//            if (bean <= l) sum += bean;
//            sum += bean - l;
//        }
//        return sum;
//    }
//
//    private boolean check1(int[] beans, long t) {
//        long pre = -1;
//        for (int bean : beans) {
//            if (bean > t && pre != -1 && bean - t != pre) {
//                return false;
//            }
//            pre = bean - t;
//        }
//        return true;
//    }
//
//    // 保留 越多越好
//    private long cal2(int[] beans, int l, int r) {
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (check1(beans, mid)) l = mid;
//            r = mid - 1;
//        }
//        long sum = 0;
//        for (int bean : beans) {
//            if (bean <= l) sum += bean;
//            sum += bean - l;
//        }
//        return sum;
//    }
//
//    private boolean check2(int[] beans, long t) {
//        long pre = -1;
//        for (int bean : beans) {
//            if (bean > t && pre != -1 && bean - t != pre) {
//                return false;
//            }
//            pre = bean - t;
//        }
//        return true;
//    }
// 第一个>=x的数
    int findL(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // 最后一个<=x的数
    int findR(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > x) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}
