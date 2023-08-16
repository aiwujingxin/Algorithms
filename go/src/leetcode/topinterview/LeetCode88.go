package topinterview

func merge(nums1 []int, m int, nums2 []int, n int) {
	index := m + n - 1
	i, j := m-1, n-1
	for i >= 0 || j >= 0 {
		if i >= 0 && j >= 0 {
			if nums1[i] < nums2[j] {
				nums1[index] = nums2[j]
				j--
				index--
			} else {
				nums1[index] = nums1[i]
				i--
				index--
			}
		} else if i >= 0 {
			nums1[index] = nums1[i]
			i--
			index--
		} else if j >= 0 {
			nums1[index] = nums2[j]
			j--
			index--
		}
	}
}
