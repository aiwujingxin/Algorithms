package offer

import "testing"

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/29 16:08
 */

func Test_isNumber(t *testing.T) {
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
				s: "+100",
			},
			want: true,
		}, {
			name: "2",
			args: args{
				s: "5e2",
			},
			want: true,
		}, {
			name: "3",
			args: args{
				s: "-123",
			},
			want: true,
		}, {
			name: "4",
			args: args{
				s: "3.1416",
			},
			want: true,
		}, {
			name: "5",
			args: args{
				s: "-1E-16",
			},
			want: true,
		}, {
			name: "6",
			args: args{
				s: "0123",
			},
			want: true,
		}, {
			name: "7",
			args: args{
				s: "12e",
			},
			want: false,
		}, {
			name: "8",
			args: args{
				s: "1a3.14",
			},
			want: false,
		}, {
			name: "9",
			args: args{
				s: "1.2.3",
			},
			want: false,
		}, {
			name: "10",
			args: args{
				s: "+-5",
			},
			want: false,
		}, {
			name: "11",
			args: args{
				s: "12e+5.4",
			},
			want: false,
		}, {
			name: "12",
			args: args{
				s: "0",
			},
			want: true,
		}, {
			name: "13",
			args: args{
				s: "e",
			},
			want: false,
		}, {
			name: "14",
			args: args{
				s: ".",
			},
			want: false,
		}, {
			name: "15",
			args: args{
				s: "    .1  ",
			},
			want: true,
		}, {
			name: "16",
			args: args{
				s: " ",
			},
			want: false,
		}, {
			name: "17",
			args: args{
				s: "e9",
			},
			want: false,
		}, {
			name: "18",
			args: args{
				s: "3.",
			},
			want: true,
		}, {
			name: "19",
			args: args{
				s: ".",
			},
			want: false,
		}, {
			name: "20",
			args: args{
				s: "1 .",
			},
			want: false,
		}, {
			name: "21",
			args: args{
				s: "4e+",
			},
			want: false,
		}, {
			name: "22",
			args: args{
				s: ".-4",
			},
			want: false,
		}, {
			name: "23",
			args: args{
				s: " -.",
			},
			want: false,
		}, {
			name: "23",
			args: args{
				s: " - .",
			},
			want: false,
		}, {
			name: "23",
			args: args{
				s: " - 4.",
			},
			want: false,
		}, {
			name: "23",
			args: args{
				s: " - 4e.",
			},
			want: false,
		}, {
			name: "23",
			args: args{
				s: " - 4e.1",
			},
			want: false,
		}, {
			name: "25",
			args: args{
				s: "46.e+3",
			},
			want: true,
		}, {
			name: "25",
			args: args{
				s: "46.e3",
			},
			want: true,
		}, {
			name: "25",
			args: args{
				s: "e+3",
			},
			want: false,
		}, {
			name: "26",
			args: args{
				s: ".e1",
			},
			want: false,
		}, {
			name: "26",
			args: args{
				s: "6.e1",
			},
			want: true,
		}, {
			name: "27",
			args: args{
				s: ".1",
			},
			want: true,
		}, {
			name: "28",
			args: args{
				s: " 4e3.",
			},
			want: false,
		}, {
			name: "28",
			args: args{
				s: " 4e.",
			},
			want: false,
		}, {
			name: "29",
			args: args{
				s: ".2e81",
			},
			want: true,
		}, {
			name: "30",
			args: args{
				s: ".e81",
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isNumber(tt.args.s); got != tt.want {
				t.Errorf("isNumber() = %v, want %v", got, tt.want)
			}
		})
	}
}
