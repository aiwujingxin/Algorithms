package classic

import (
	"reflect"
	"testing"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/25 14:36
 */

func Test_drawLine(t *testing.T) {
	type args struct {
		length int
		w      int
		x1     int
		x2     int
		y      int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "1",
			args: args{
				length: 9,
				w:      96,
				x1:     23,
				x2:     87,
				y:      2,
			},
			want: []int{0, 0, 0, 0, 0, 0, 511, -1, -256},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := drawLine(tt.args.length, tt.args.w, tt.args.x1, tt.args.x2, tt.args.y); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("drawLine() = %v, want %v", got, tt.want)
			}
		})
	}
}
