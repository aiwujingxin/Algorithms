package LeetCode;

public class LeetCode85 {


    public static void main(String[] args) {
        System.out.println(new LeetCode85().maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}}));
    }


    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] left = new int[row][col];//to keep track of max left.->->->
        int[][] up = new int[row][col];//to keep track of max top.^
        int max = 0;
        if (matrix[0][0] == '1') {
            left[0][0] = 1;
            up[0][0] = 1;
            max = 1;
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == '1') {
                up[i][0] = up[i - 1][0] + 1;
                left[i][0] = 1;
                max = Math.max(up[i][0], max);
            }
        }

        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == '1') {
                left[0][j] = left[0][j - 1] + 1;
                up[0][j] = 1;
                max = Math.max(left[0][j], max);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int upto = 0;
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;

                    if (left[i][j] > 1 && up[i][j] > 1) {
                        int val = 0;
                        int track = i;
                        int min = left[i][j];
                        //this is important when both top and left are non zero
                        while (track >= 0 && left[track][j] >= 1 && up[track][j] >= 1) {
                            if (min > left[track][j]) {
                                min = left[track][j];
                            }
                            val++;
                            upto = Math.max(min * val, upto);
                            track--;
                        }
                    }
                    max = Math.max(max, Math.max(left[i][j], Math.max(up[i][j], upto)));
                } else {
                    left[i][j] = 0;
                    up[i][j] = 0;
                }
            }
        }
        return max;
    }

    public int maximalRectangle_2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] leftLessMin = new int[heights.length];
        leftLessMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = leftLessMin[l];
            }
            leftLessMin[i] = l;
        }

        int[] rightLessMin = new int[heights.length];
        rightLessMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int r = i + 1;
            while (r <= heights.length - 1 && heights[r] >= heights[i]) {
                r = rightLessMin[r];
            }
            rightLessMin[i] = r;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightLessMin[i] - leftLessMin[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

}
