package topinterview

func maxPoints(points [][]int) int {
	n := len(points)
	if n <= 2 { //fix
		return n
	}
	res := 2
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			//fix
			count := 2
			for k := j + 1; k < n; k++ {
				if (points[i][0]-points[j][0])*(points[j][1]-points[k][1]) ==
					(points[i][1]-points[j][1])*(points[j][0]-points[k][0]) {
					count++
				}
			}
			res = Max(res, count)
		}
	}
	return res
}
