package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/23/25 12:59
 */
public class LeetCode923 {

    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        int ans = 0;
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = target - arr[i] - arr[j];
                List<Integer> list = map.get(x);
                if (list == null) continue;
                int index = findL(list, j + 1);
                if (index == -1) continue;
                int len = list.size() - index;
                ans = (ans + len) % mod;
            }
        }
        return ans;
    }

    public int findL(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        if (arr.get(l) < target) {
            return -1;
        }
        return l;
    }
}
