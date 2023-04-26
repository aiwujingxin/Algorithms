package offer

import "testing"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 21:55
 */

func Test_strToInt(t *testing.T) {
	type args struct {
		str string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{
				str: "42",
			},
			want: 42,
		},
		{
			name: "2",
			args: args{
				str: "   -42",
			},
			want: -42,
		}, {
			name: "3",
			args: args{
				str: "4193 with words",
			},
			want: 4193,
		}, {
			name: "4",
			args: args{
				str: "words and 987",
			},
			want: 0,
		}, {
			name: "5",
			args: args{
				str: "-91283472332",
			},
			want: -2147483648,
		}, {
			name: "6",
			args: args{
				str: "+",
			},
			want: 0,
		}, {
			name: "7",
			args: args{
				str: "+w",
			},
			want: 0,
		}, {
			name: "8",
			args: args{
				str: "+ w",
			},
			want: 0,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := strToInt(tt.args.str); got != tt.want {
				t.Errorf("strToInt() = %v, want %v", got, tt.want)
			}
		})
	}
}
