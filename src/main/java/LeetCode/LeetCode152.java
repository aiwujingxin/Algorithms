package LeetCode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jingxinwu
 * @date 2021-08-04 11:21 下午
 */
public class LeetCode152 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put(null, "-1");
        map.put("-1", "0");
        System.out.println(map1.get(null));
    }

    public static int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);

            System.out.println("maxF " + maxF + " minF " + minF + " ans " + ans + " num " + nums[i]);
        }
        return ans;
    }
}
