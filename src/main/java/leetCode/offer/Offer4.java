package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-19 9:07 下午
 */
public class Offer4 {

    public static void main(String[] args) {
        Offer4 offer4 = new Offer4();
        int[][] arr = new int[][]{{-5}};
        System.out.println(offer4.findNumberIn2DArray(arr, -5));
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int i = matrix[0].length - 1;
        int j = 0;
        while (i >= 0 && j < matrix.length) {
            int temp = matrix[j][i];
            if (temp == target) {
                return true;
            } else if (temp < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
