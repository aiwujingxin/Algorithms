package LeetCode;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2021-12-20 11:04 AM
 */
public class LeetCode560 {

    public static void main(String[] args) {
        System.out.println(new LeetCode560().sum(new int[]{1, 1, -1, 1, 1, 1}));
    }


    public int sum(int[] nums) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre)) {
                count += mp.get(pre);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
