package classic

import (
	"reflect"
	"testing"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/18 16:26
 */

func Test_printKMoves(t *testing.T) {
	type args struct {
		K int
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{
			name: "2",
			args: args{
				K: 2,
			},
			want: []string{"_X", "LX"},
		}, {
			name: "5",
			args: args{
				K: 5,
			},
			want: []string{"_U", "X_", "XX"},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := printKMoves(tt.args.K); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("printKMoves() = %v, want %v", got, tt.want)
			}
		})
	}
}
