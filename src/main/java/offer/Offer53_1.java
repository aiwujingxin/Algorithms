package offer;

/**
 * @author jingxinwu
 * @date 2021-11-24 1:04 上午
 */
public class Offer53_1 {

    public static void main(String[] args) {
        System.out.println(new Offer53_1().search(new int[]{1}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                count++;
                int temp = mid;
                while (temp > 0 && nums[temp - 1] == target) {
                    count++;
                    temp--;
                }
                int temp1 = mid;
                while (temp1 < nums.length - 1 && nums[temp1 + 1] == target) {
                    count++;
                    temp1++;
                }
                return count;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return count;
    }

}
