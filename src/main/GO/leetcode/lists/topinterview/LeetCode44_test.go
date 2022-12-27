package topinterview

import "testing"

func Test_isMatch(t *testing.T) {
	type args struct {
		s string
		p string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "1",
			args: args{
				s: "aa",
				p: "a",
			},
			want: false,
		}, {
			name: "2",
			args: args{
				s: "aa",
				p: "*",
			},
			want: true,
		}, {
			name: "3",
			args: args{
				s: "cb",
				p: "?a",
			},
			want: false,
		}, {
			name: "4",
			args: args{
				s: "adceb",
				p: "*a*b",
			},
			want: true,
		}, {
			name: "5",
			args: args{
				s: "acdcb",
				p: "a*c?b",
			},
			want: false,
		}, {
			name: "5",
			args: args{
				s: "acdcb",
				p: "a*c?b",
			},
			want: false,
		}, {
			name: "6",
			args: args{
				s: "abcabczzzde",
				p: "*abc???de*",
			},
			want: true,
		}, {
			name: "7",
			args: args{
				s: "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
				p: "a*******b",
			},
			want: false,
		}, {
			name: "8",
			args: args{
				s: "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
				p: "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*",
			},
			want: true,
		}, {
			name: "9",
			args: args{
				s: "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
				p: "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a",
			},
			want: false,
		}, {
			name: "10",
			args: args{
				s: "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
				p: "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb",
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isMatch(tt.args.s, tt.args.p); got != tt.want {
				t.Errorf("isMatch() = %v, want %v", got, tt.want)
			}
		})
	}
}
