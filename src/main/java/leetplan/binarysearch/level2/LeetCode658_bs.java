package leetplan.binarysearch.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/31 22:36
 */
public class LeetCode658_bs {

    //https://leetcode.cn/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/

    //https://leetcode.com/problems/find-k-closest-elements/discuss/2636647/Java-oror-Explained-in-Detailoror-Binary-Search-oror-Two-Pointers-oror-Priority-Queue
    public static void main(String[] args) {
//        System.out.println(new LeetCode658_bs().findClosestElements(new int[]{1, 2, 3, 4, 5, 6}, 4, 4));
//        System.out.println(new LeetCode658_bs().findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
//        System.out.println(new LeetCode658_bs().findClosestElements(new int[]{1, 2, 3, 5, 6, 6, 6, 6, 6}, 4, 4));
//        System.out.println(new LeetCode658_bs().findClosestElements(new int[]{1, 3, 3, 3, 3, 4, 5, 5, 5, 5}, 4, 4));
//        System.out.println(new LeetCode658_bs().findClosestElements(new int[]{0, 2, 2, 3, 4, 6, 7, 8, 9, 9}, 4, 5));
        System.out.println(new LeetCode658_bs().findClosestElements(new int[]{1, 2, 3, 4, 4, 4, 4, 5, 5}, 3, 3));


    }

    // We'll take left=0 and right=arr.length-k and then apply binary search
    // to find first index which will be the smallest value in K the closest values.
    // Then we'll linearly traverse and add K values to our list.
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1; //尽可能的将错误的部分排除
            } else if (x - arr[mid] == arr[mid + k] - x) {
                right = mid - 1;
                //right = mid - 1 时的 bad case
                //[1,2,3,4,4,4,4,5,5]
                //3
                //3
            } else if (x - arr[mid] < arr[mid + k] - x) {
                right = mid;
                //right = mid - 1;时的 bad case
                //[0,2,2,3,4,6,7,8,9,9]
                //4
                //5
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
