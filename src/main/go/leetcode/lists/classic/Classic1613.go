package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/14 17:20
 */

func cutSquares(square1 []int, square2 []int) []float64 {
	x1, y1, d1 := float64(square1[0])+float64(square1[2])/2, float64(square1[1])+float64(square1[2])/2, square1[2]
	x2, y2, d2 := float64(square2[0])+float64(square2[2])/2, float64(square2[1])+float64(square2[2])/2, square2[2]

	var point1X, point1Y, point2X, point2Y float64
	abs := func(i float64) float64 {
		if i < 0 {
			return -i
		}
		return i
	}
	if x1 == x2 {
		point1X = x1
		point1Y = float64(Min(square1[1], square2[1]))
		point2X = x1
		point2Y = float64(Max(square1[1]+d1, square2[1]+d2))
		return []float64{point1X, point1Y, point2X, point2Y}
	}
	k := (y1 - y2) / (x1 - x2) //斜率计算公式
	b := y1 - k*x1
	if abs(k) > 1 {
		//斜率绝对值>1，上下相交
		point1Y = float64(Min(square1[1], square2[1]))
		point1X = (point1Y - b) / k
		point2Y = float64(Max(square1[1]+d1, square2[1]+d2))
		point2X = (point2Y - b) / k
	} else {
		//斜率绝对值小于等于1，左右相交
		point1X = float64(Min(square1[0], square2[0]))
		point1Y = point1X*k + b
		point2X = float64(Max(square1[0]+d1, square2[0]+d2))
		point2Y = point2X*k + b
	}
	if point1X > point2X {
		point1X, point1Y, point2X, point2Y = point2X, point2Y, point1X, point1Y
	}
	return []float64{point1X, point1Y, point2X, point2Y}
}
