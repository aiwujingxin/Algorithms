package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/1 16:03
 */

func minEatingSpeed(piles []int, h int) int {

	if len(piles) == 0 {
		return 0
	}
	max := 0
	for _, p := range piles {
		max = Max(max, p)
	}
	left, right := 1, max
	for left < right {
		mid := (right-left)/2 + left
		time := 0
		for _, pile := range piles {
			time += (pile + mid - 1) / mid
		}
		if time > h {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}
