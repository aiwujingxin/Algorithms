package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 15:41
 */

func mySqrt(x int) int {
	l, r, ans := 0, x, -1
	for l <= r {
		mid := l + (r-l)/2
		if mid*mid <= x {
			ans = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return ans
}
