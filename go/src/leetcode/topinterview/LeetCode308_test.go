package topinterview

import (
	"reflect"
	"testing"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/26 15:35
 */

func TestConstructorNumMatrix(t *testing.T) {
	type args struct {
		matrix [][]int
	}
	tests := []struct {
		name string
		args args
		want NumMatrix
	}{
		{
			name: "1",
			args: args{
				matrix: [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
			},
			want: NumMatrix{
				matrix:    [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
				sumMatrix: [][]int{{1, 3, 6}, {5, 12, 21}, {12, 27, 45}},
			},
		}, {
			name: "1",
			args: args{
				matrix: [][]int{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}},
			},
			want: NumMatrix{
				matrix:    [][]int{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}},
				sumMatrix: [][]int{{3, 3, 4, 8, 10}, {8, 14, 18, 24, 27}, {9, 17, 21, 28, 36}, {13, 22, 26, 34, 49}, {14, 23, 30, 38, 58}},
			},
		}}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := ConstructorNumMatrix(tt.args.matrix); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("ConstructorNumMatrix() = %v, want %v", got, tt.want)
			}
		})
	}
}
