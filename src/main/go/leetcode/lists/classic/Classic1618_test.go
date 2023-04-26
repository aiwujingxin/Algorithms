package classic

import "testing"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/17 17:56
 */

func Test_patternMatching(t *testing.T) {
	type args struct {
		pattern string
		value   string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "1",
			args: args{
				pattern: "abba",
				value:   "dogcatcatdog",
			},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := patternMatching(tt.args.pattern, tt.args.value); got != tt.want {
				t.Errorf("patternMatching() = %v, want %v", got, tt.want)
			}
		})
	}
}
