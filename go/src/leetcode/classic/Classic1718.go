package classic

import (
	"math"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/13 23:02
 */

func shortestSeq(big []int, small []int) []int {
	if len(big) < len(small) {
		return []int{}
	}
	need := make(map[int]int)
	for i := 0; i < len(small); i++ {
		need[small[i]]++
	}
	window := make(map[int]int)
	valid := 0
	left, right := 0, 0
	length := math.MaxInt32
	l, r := math.MaxInt32, math.MaxInt32
	for right < len(big) {
		num := big[right]
		if _, ok := need[num]; ok {
			window[num]++
			if window[num] == need[num] {
				valid++
			}
		}
		if valid == len(need) && left < l {
			length = right - left + 1
			l, r = left, right
		}
		for left < right && right-left-1 > len(small) && valid > len(need) {
			if right-left+1 < length && left < l {
				length = right - left + 1
				l, r = left, right
			}
			d := big[left]
			if _, ok := need[d]; ok {
				if window[d] == need[d] {
					valid--
				}
				window[d]--
			}
			left++
		}
		right++
	}
	if l == math.MaxInt32 && r == math.MaxInt32 {
		return []int{}
	}
	return []int{l, r}
}
