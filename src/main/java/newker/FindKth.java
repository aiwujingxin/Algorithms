package newker;

public class FindKth {

    public static void main(String[] args) {
        FindKth kth = new FindKth();
        int[] a = new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891,
                1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742,
                883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799,
                1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786,
                937247, 986578, 798663};
        System.out.println(kth.findKth(a, 49, 24));

        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(kth.findKth(b, 9, 8));
    }

    public int findKth(int[] a, int n, int K) {
        randomizedSelected(a, 0, n - 1, K);
        return a[K + 1];
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = partitionV2(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }


    private int partitionV2(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (nums[r] >= pivot && l < r) {
                r--;
            }
            nums[l] = nums[r];
            while (nums[l] <= pivot && l < r) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
