package basic.structure.array;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 17:12
 */
public interface QuickSelect {

    //数组中的第K个最大元素 https://leetcode.cn/problems/kth-largest-element-in-an-array/
    int findKthLargest(int[] nums, int k);

    int findKthSmallest(int[] nums, int k);
}
