package LeetCode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/23 19:29
 */
public class LeetCode315_BIT {

    //https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/2319975/Easy-to-understand-Java-codes-oror-Fenwick-tree-Segment-tree

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        int size;
        List<Integer> numsClone;
        int[] fenArr;

        for (int idx = 0; idx < len; idx++) {
            set.add(nums[idx]);
        }

        numsClone = new ArrayList<>(set);
        Collections.sort(numsClone);
        size = numsClone.size();
        fenArr = new int[size + 1];

        for (int idx = 0; idx < size; idx++) {
            numToIdx.put(numsClone.get(idx), idx + 1);
        }

        for (int currIdx = len - 1; currIdx >= 0; currIdx--) {
            int idx = numToIdx.get(nums[currIdx]);
            int count = query(fenArr, idx - 1, size);
            ans.add(count);
            update(fenArr, idx, size);
        }

        Collections.reverse(ans);
        return ans;
    }

    private int query(int[] fenArr, int num, int size) {
        int ans = 0;

        while (num > 0) {
            ans += fenArr[num];
            num -= (num & (-num));
        }

        return ans;
    }

    private void update(int[] fenArr, int num, int size) {
        while (num < size) {
            fenArr[num]++;
            num += (num & (-num));
        }
    }
}
