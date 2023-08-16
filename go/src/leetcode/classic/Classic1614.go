package classic

import "math"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/14 00:09
 */

func bestLine(points [][]int) []int {
	if len(points) < 1 {
		return []int{}
	}
	max := 2
	s1, s2 := math.MaxInt32, math.MaxInt32
	for x := 0; x < len(points); x++ {
		for y := x + 1; y < len(points); y++ {
			t := 2
			for k := y + 1; k < len(points); k++ {
				if (points[k][1]-points[x][1])*(points[y][0]-points[k][0]) ==
					(points[y][1]-points[k][1])*(points[k][0]-points[x][0]) {
					t++
				}
			}
			if t > max {
				s1 = x
				s2 = y
				max = t
			}
		}
	}
	if max == 2 {
		return []int{0, 1}
	}
	return []int{s1, s2}
}
