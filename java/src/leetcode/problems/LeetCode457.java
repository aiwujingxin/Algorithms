package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 16:37
 */
public class LeetCode457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = getNext(nums, i);

            // 保证同方向
            while (nums[slow] * nums[fast] > 0) {
                if (slow == fast) {
                    // 死循环, 只有一个点, 不算循环: [-1,2]
                    if (slow == getNext(nums, slow)) {
                        break;
                    }
                    return true;
                }

                // [-2,1,-1,"-2",-2]
                if (nums[fast] * nums[getNext(nums, fast)] < 0) {
                    break;
                }

                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            }
        }

        return false;
    }

    private int getNext(int[] nums, int index) {
        int next = (index + nums[index]) % nums.length;
        if (next >= 0) {
            return next;
        }
        return next + nums.length;
    }
}
