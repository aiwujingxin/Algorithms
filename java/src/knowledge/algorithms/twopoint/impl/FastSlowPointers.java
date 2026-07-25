package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 快慢双指针模板 (Fast and Slow Pointers Template)
 * 常用于数组去重、原地修改数组、链表中寻找中点等问题。
 */
public class FastSlowPointers {

    /**
     * 快慢指针数组去重模板
     *
     * @param nums 输入数组
     * @return 去重后的新长度
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
