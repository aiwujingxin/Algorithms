package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-03-11 8:01 PM
 */
public class Dance {

    public static void main(String[] args) {
//        System.out.println(new Dance().search(new int[]{8, 7, 6, 5, 3, 3, 2, 1}, 3));

        System.out.println(new Dance().find(new int[]{9, 7, 6, 5, 2, 2}, 22));
        System.out.println(new Dance().find(new int[]{5, 4, 3, 2, 1}, 10));
        System.out.println(new Dance().find(new int[]{5, 4, 3, 3, 1}, 11));
        System.out.println(new Dance().find(new int[]{10, 10, 3, 2, 1}, 14));
    }

    public List<Integer> find(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, nums, target);
        return list;

    }

    public void dfs(List<Integer> temp, int left, int[] nums, int target) {
        if (target <= 0) {
            return;
        }
        int index = search(nums, left, target);
        temp.add(index);
        dfs(temp, index + 1, nums, target - nums[index]);
    }

    public int search(int[] nums, int left, int target) {
        if (target >= nums[left]) {
            return left;
        }
        int lf = left, rt = nums.length - 1;
        while (lf <= rt) {
            int mid = lf + (rt - lf) / 2;
            if (nums[mid] < target) {
                rt = mid - 1;
            } else {
                lf = mid + 1;
            }
        }
        return lf - 1;
    }
}
