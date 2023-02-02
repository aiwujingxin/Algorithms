package basic.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 00:02
 */
public class SearchLastSmallerOrEqual implements BinarySearch {

    //find the index of first element that is bigger than or equals target
    public int search(int[] nums, int target) {
        return binarySearch(target, 0, nums.length, nums);
    }

    public int binarySearch(int target, int beg, int end, int[] nums) {
        return -1;
    }
}
