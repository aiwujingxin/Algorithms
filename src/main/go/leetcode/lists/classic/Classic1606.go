package classic

import (
	"math"
	"sort"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/9 16:37
 */
func smallestDifference(a []int, b []int) int {
	sort.Ints(b)
	min := math.MaxInt32
	search := func(target int) (int, int) {
		l, r := 0, len(b)-1
		for l <= r {
			mid := (l + r) / 2
			if b[mid] == target {
				return target, target
			}
			if b[mid] > target {
				r = mid - 1

			} else {
				l = mid + 1

			}
		}

		if l == len(b) {
			return b[r], b[r]
		}
		if r == -1 {
			return b[l], b[l]
		}

		return b[r], b[l]
	}
	for i := 0; i < len(a); i++ {
		left, right := search(a[i])
		min = Min(Min(Abs(left-a[i]), Abs(right-a[i])), min)
	}
	return min
}
