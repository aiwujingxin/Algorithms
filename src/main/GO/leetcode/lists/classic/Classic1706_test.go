package classic

import "testing"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/26 21:18
 */

func Test_numberOf2sInRange(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{
				n: 341241,
			},
			want: 276396,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numberOf2sInRange(tt.args.n); got != tt.want {
				t.Errorf("numberOf2sInRange() = %v, want %v", got, tt.want)
			}
		})
	}
}
