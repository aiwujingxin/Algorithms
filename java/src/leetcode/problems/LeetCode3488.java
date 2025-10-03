package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/4/25 10:13
 */
public class LeetCode3488 {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n * 2; i++) {
            int index = i % n;
            int num = nums[index];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
        System.out.println(map);
        List<Integer> ans = new ArrayList<>();
        for (int index : queries) {
            int num = nums[index];
            List<Integer> list = map.get(num);
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }
            int dis = Integer.MAX_VALUE;
            int listPosA = bs(list, index);
            if (listPosA > 0) {
                dis = Math.min(dis, Math.abs(index - list.get(listPosA - 1)));
            }
            if (listPosA < 2 * n - 1) {
                dis = Math.min(dis, Math.abs(index - list.get(listPosA + 1)));
            }
            int b = index + n;
            int listPosB = bs(list, b);
            if (listPosB > 0) {
                dis = Math.min(dis, Math.abs(b - list.get(listPosB - 1)));
            }
            if (listPosB < 2 * n - 1) {
                dis = Math.min(dis, Math.abs(b - list.get(listPosB + 1)));
            }
            ans.add(dis);
        }
        return ans;
    }

    int bs(List<Integer> a, int x) {
        int l = 0;
        int r = a.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a.get(mid) == x) return mid;
            if (a.get(mid) < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
