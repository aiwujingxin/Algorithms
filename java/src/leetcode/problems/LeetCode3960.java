package leetcode.problems;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 6/28/26 21:41
 */
public class LeetCode3960 {

    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> cntMap = new HashMap<>();
            TreeMap<Integer, Integer> fMap = new TreeMap<>();
            for (int j = i; j < n; j++) {
                int num = nums[j];
                int oldF = cntMap.getOrDefault(num, 0);
                int newF = oldF + 1;
                if (oldF > 0) { // 只有当 oldF > 0 时才需要从 fMap 中移除
                    if (fMap.get(oldF) == 1) {
                        fMap.remove(oldF);
                    } else {
                        fMap.put(oldF, fMap.get(oldF) - 1);
                    }
                }
                fMap.merge(newF, 1, Integer::sum);
                int minFreq = fMap.firstKey();
                cntMap.put(num, newF);

                if (cntMap.size() == 1) {
                    ans = Math.max(ans, j - i + 1);
                } else if (fMap.size() == 2) {
                    if (fMap.containsKey(minFreq) && fMap.containsKey(minFreq * 2)) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
        }
        return ans;
    }
}
