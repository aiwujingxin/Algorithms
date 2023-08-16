package offer

import (
	"reflect"
	"testing"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 18:41
 */

func Test_printNumbers(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "1",
			args: args{
				n: 2,
			},
			want: nil,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := printNumbers(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("printNumbers() = %v, want %v", got, tt.want)
			}
		})
	}
}
