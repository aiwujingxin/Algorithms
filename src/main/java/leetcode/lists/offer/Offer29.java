package leetcode.lists.offer;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-11-21 7:09 下午
 */
public class Offer29 {


    public static void main(String[] args) {
        Offer29 offer29 = new Offer29();
//        System.out.println(Arrays.toString(offer29.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
        System.out.println(Arrays.toString(offer29.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length ==0) return new int[]{};


        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++) {
                res[index] = matrix[rowStart][i];
                index++;
            }

            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                res[index] = matrix[i][colEnd];
                index++;
            }

            colEnd--;

            if (rowStart <= rowEnd) {//避免col还有，row没有的情况，rowStart++改变了row
                //必须保证有row有col
                for (int i = colEnd; i >= colStart; i--) {
                    res[index] = matrix[rowEnd][i];
                    index++;
                }
            }

            rowEnd--;

            if (colStart <= colEnd) {//
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[index] = matrix[i][colStart];
                    index++;
                }
            }
            colStart++;

        }
        return res;
    }

}
