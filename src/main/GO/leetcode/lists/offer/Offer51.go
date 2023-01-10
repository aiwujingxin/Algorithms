package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/10 16:16
 */

func reversePairs(nums []int) int {
	var res = 0
	tmp := make([]int, len(nums))
	var mergeSort func(arr []int, l int, r int)
	mergeSort = func(arr []int, l int, r int) {
		if l < r {
			// Find the middle point
			m := l + (r-l)/2
			// Sort first and second halves
			mergeSort(arr, l, m)
			mergeSort(arr, m+1, r)
			// Merge the sorted halves
			i := l
			j := m + 1
			for k := l; k <= r; k++ {
				tmp[k] = nums[k]
			}
			for k := l; k <= r; k++ {
				if i == m+1 {
					nums[k] = tmp[j]
					j++
				} else if j == r+1 || tmp[i] <= tmp[j] {
					nums[k] = tmp[i]
					i++
				} else {
					nums[k] = tmp[j]
					j++
					res += m - i + 1 // 统计逆序对
				}
			}
		}
	}
	mergeSort(nums, 0, len(nums)-1)
	return res
}
