package hot100

import "math"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	n1, n2 := len(nums1), len(nums2)
	if n1 > n2 {
		return findMedianSortedArrays(nums2, nums1)
	}
	length := n1 + n2
	l, r := 0, n1
	for l <= r {
		cutA := (l + r) / 2
		cutB := (length+1)/2 - cutA //左半边比右半边多一个元素
		var (
			L1 int
			R1 int
			L2 int
			R2 int
		)
		if cutA == 0 {
			L1 = math.MinInt32
		} else {
			L1 = nums1[cutA-1]
		}
		if cutB == 0 {
			L2 = math.MinInt32
		} else {
			L2 = nums2[cutB-1]
		}
		if cutA == n1 {
			R1 = math.MaxInt32
		} else {
			R1 = nums1[cutA]
		}
		if cutB == n2 {
			R2 = math.MaxInt32
		} else {
			R2 = nums2[cutB]
		}
		if L2 <= R1 && L1 <= R2 {
			if (n1+n2)%2 == 0 {
				return (float64(Max(L1, L2)) + float64(Min(R1, R2))) * 0.5
			}
			return float64(Max(L1, L2))
		} else if L1 > R2 {
			r = cutA - 1
		} else if L2 > R1 {
			l = cutA + 1
		}
	}
	return -1
}
