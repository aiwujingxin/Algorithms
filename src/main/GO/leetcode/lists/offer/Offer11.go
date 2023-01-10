package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:32
 */

func minArray(numbers []int) int {
	if len(numbers) == 0 {
		return 0
	}
	left, right := 0, len(numbers)-1
	for left < right {
		mid := (left + right) / 2
		if numbers[mid] > numbers[right] {
			left = mid + 1
		} else if numbers[mid] < numbers[right] {
			right = mid
		} else {
			right--
		}
	}
	return numbers[left]
}
