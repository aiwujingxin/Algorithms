package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:46
 */
public class LeetCode870_bs {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        //minIndex 是最小元素的索引
        int n = nums1.length, minIndex = 0;
        //判断num1的元素 是否使用
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        //排序
        Arrays.sort(nums1);
        for (int i = 0; i < n; i++) {
            int left = 0, right = n;
            //二分查找 找最小的大于 num2[i]的元素
            while (left != right) {
                int mid = left + ((right - left) >> 1);
                if (nums1[mid] < nums2[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            //是否访问 或者 相同
            while (left < n && (visited[left] || nums1[left] == nums2[i])) {
                left++;
            }
            if (left == n) {
                //没有大于num[i]的元素，取最小的元素
                while (visited[minIndex]) {
                    minIndex++;
                }
                ans[i] = nums1[minIndex];
                visited[minIndex++] = true;
            } else {
                visited[left] = true;
                ans[i] = nums1[left];
            }
        }
        return ans;
    }
}
