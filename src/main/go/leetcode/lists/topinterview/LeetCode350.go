package topinterview

func intersect(nums1 []int, nums2 []int) []int {
	arr1, arr2 := make([]int, 1001), make([]int, 1001)
	for i := 0; i < len(nums1); i++ {
		arr1[nums1[i]]++
	}
	for i := 0; i < len(nums2); i++ {
		arr2[nums2[i]]++
	}
	list := make([]int, 0)
	for i := 0; i < 1001; i++ {
		if arr1[i] > 0 && arr2[i] > 0 {
			for j := 0; j < Min(arr1[i], arr2[i]); j++ {
				list = append(list, i)
			}
		}
	}
	return list
}
