package offer

import "strconv"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 23:27
 */

func findNthDigit(n int) int {
	if n == 0 {
		return 0
	}
	start, base, digitCount := 1, 9, 1

	for n > base*digitCount {
		n -= base * digitCount
		base *= 10
		start *= 10
		digitCount++
	}
	start += (n - 1) / digitCount
	num := strconv.Itoa(start)

	return int(num[(n-1)%digitCount] - '0')
}
