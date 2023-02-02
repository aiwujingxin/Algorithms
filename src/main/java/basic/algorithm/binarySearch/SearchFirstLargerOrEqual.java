package basic.algorithm.binarySearch;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 00:02
 */
public class SearchFirstLargerOrEqual implements BinarySearch {

    //find the index of first element that is bigger than or equals target
    public static void main(String[] args) {
//        System.out.println(new SearchFirstLargerOrEqual().search(new int[]{1, 2, 3, 4, 5, 7, 7, 8, 8, 10}, 6));
//        System.out.println(new SearchFirstLargerOrEqual().search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 10}, 11));
//        System.out.println(new SearchFirstLargerOrEqual().search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 10}, 11));
//        System.out.println(new SearchFirstLargerOrEqual().search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 11}, 11));
        System.out.println(new SearchFirstLargerOrEqual().search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7}, 11));
    }

    public int search(int[] nums, int target) {
        return binarySearch(target, 0, nums.length, nums);
//        return binarySearch(target, 0, nums.length - 1, nums); // ? 不是一回事了？
    }

    public int binarySearch(int target, int beg, int end, int[] nums) {
        int left = beg;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //因为有了这一行，那么意味着没找到的话该元素的话，就返回-1
        if (right == nums.length - 1 && nums[right] < target) {
            return -1;
        }
        return right;
//        return left; 一样，因为 left == right
    }
}
