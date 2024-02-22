package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 19:03
 */
public class LeetCode1636 {

    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i)[0];
            int cnt = list.get(i)[1];
            for (int j = 0; j < cnt; j++) {
                res[index] = num;
                index++;
            }
        }
        return res;
    }
}
