package basicKnowledge.dataStructure.array;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/22 22:55
 */
public interface TopK {

    //数组中的第K个最大元素 https://leetcode.cn/problems/kth-largest-element-in-an-array/
    int findKthLargest(int[] nums, int k);

    int findKthSmallest(int[] nums, int k);
}
