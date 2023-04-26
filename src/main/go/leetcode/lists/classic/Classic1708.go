package classic

import (
	"sort"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/15 17:13
 */

func bestSeqAtIndex(height []int, weight []int) int {
	peoples := make([][]int, len(height))
	for i := 0; i < len(peoples); i++ {
		peoples[i] = []int{height[i], weight[i]}
	}
	sort.Slice(peoples, func(i, j int) bool {
		if peoples[i][0] != peoples[j][0] {
			return peoples[i][0] < peoples[j][0]
		}
		return peoples[i][1] < peoples[j][0]
	})

	return maxEnvelopesOpt(peoples)
}

func maxEnvelopesOpt(envelopes [][]int) int {
	sort.Slice(envelopes, func(i, j int) bool {
		a, b := envelopes[i], envelopes[j]
		return a[0] < b[0] || a[0] == b[0] && a[1] > b[1]
	})

	var f []int
	for _, e := range envelopes {
		h := e[1]
		if i := sort.SearchInts(f, h); i < len(f) {
			f[i] = h
		} else {
			f = append(f, h)
		}
	}
	return len(f)
}

func maxEnvelopes(envelopes [][]int) int {
	n := len(envelopes)
	if n == 0 {
		return 0
	}

	sort.Slice(envelopes, func(i, j int) bool {
		a, b := envelopes[i], envelopes[j]
		return a[0] < b[0] || a[0] == b[0] && a[1] > b[1]
	})

	f := make([]int, n)
	for i := range f {
		f[i] = 1
	}
	for i := 1; i < n; i++ {
		for j := 0; j < i; j++ {
			if envelopes[j][1] < envelopes[i][1] {
				f[i] = max(f[i], f[j]+1)
			}
		}
	}
	return max(f...)
}

func max(a ...int) int {
	res := a[0]
	for _, v := range a[1:] {
		if v > res {
			res = v
		}
	}
	return res
}

func lengthOfLIS(nums []int) int {
	var list []int

	for _, num := range nums {
		if len(list) == 0 || num > list[len(list)-1] {
			list = append(list, num)
		} else {
			i := 0
			j := len(list) - 1

			for i < j {
				mid := (i + j) / 2
				if list[mid] < num {
					i = mid + 1
				} else {
					j = mid
				}
			}

			list[j] = num
		}
	}

	return len(list)
}

// https://leetcode.com/problems/longest-increasing-subsequence/submissions/898401756/
func LengthOfLIS(nums [][]int) int {
	var list [][]int

	for _, num := range nums {
		if len(list) == 0 || num[0] > list[len(list)-1][0] && num[1] > list[len(list)-1][1] {
			list = append(list, num)
		} else {
			i := 0
			j := len(list) - 1

			for i < j {
				mid := (i + j) / 2
				if list[mid][0] < num[0] && list[mid][1] < num[1] {
					i = mid + 1
				} else {
					j = mid
				}
			}

			list[j] = num
		}
	}
	return len(list)
}
