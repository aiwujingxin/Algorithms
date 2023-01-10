package _023daily

import "testing"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 18:13
 */

func Test_areNumbersAscending(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "1",
			args: args{
				s: "1 box has 3 blue 4 red 6 green and 12 yellow marbles",
			},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := areNumbersAscending(tt.args.s); got != tt.want {
				t.Errorf("areNumbersAscending() = %v, want %v", got, tt.want)
			}
		})
	}
}
