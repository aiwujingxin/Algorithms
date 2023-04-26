package classic

import "math"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/26 20:33
 */
func intersection(start1 []int, end1 []int, start2 []int, end2 []int) []float64 {
	point := intersectionH(NewPoint(float64(start1[0]), float64(start1[1])), NewPoint(float64(end1[0]), float64(end1[1])), NewPoint(float64(start2[0]), float64(start2[1])), NewPoint(float64(end2[0]), float64(end2[1])))

	if point == nil {
		return []float64{}
	}
	return []float64{point.x, point.y}

}

func intersectionH(start1, end1, start2, end2 *Point) *Point {
	line1 := NewLine(start1, end1)
	line2 := NewLine(start2, end2)
	if line1.slope == line2.slope {
		if line1.yintercept != line2.yintercept {
			return nil
		}
		if isBetween(start2, start1, end2) {
			return start1
		} else if isBetween(start2, end1, end2) {
			return end1
		} else if isBetween(start1, start2, end1) {
			return start2
		} else if isBetween(start1, end2, end1) {
			return end2
		} else {
			return nil
		}
	}

	var x, y float64
	if line1.isVertical() || line2.isVertical() { /* If a line is vertical, use its x coordinate. */
		if line1.isVertical() {
			x = line1.start.x
		} else {
			x = line2.start.x
		}
	} else { /* Set y = mx + b equations equal and solve for x */
		x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope)
	}
	if line1.isVertical() {
		y = line2.getYFromX(x)
	} else {
		y = line1.getYFromX(x)
	}
	intersection := NewPoint(x, y)
	if isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2) {
		return intersection
	}
	return nil
}

func isBetween(start, middle, end *Point) bool {
	return isBetweenH(start.x, middle.x, end.x) && isBetweenH(start.y, middle.y, end.y)
}

func isBetweenH(start, middle, end float64) bool {
	if start > end {
		return end <= middle && middle <= start
	} else {
		return start <= middle && middle <= end
	}
}

type Point struct {
	x, y float64
}

func NewPoint(x float64, y float64) *Point {
	return &Point{x: x, y: y}
}

type Line struct {
	slope, yintercept float64
	start, end        *Point
}

func (l *Line) isVertical() bool {
	return l.slope == math.MinInt32
}

func (l *Line) getYFromX(x float64) float64 {
	if l.isVertical() {
		return math.MinInt32
	}
	return l.slope*x + l.yintercept
}
func NewLine(start, end *Point) *Line {
	line := &Line{}
	line.start = start
	line.end = end
	if start.x == end.x {
		line.slope = math.MinInt32
		line.yintercept = math.MinInt32
	} else {
		line.slope = (end.y - start.y) / (end.x - start.x)
		line.yintercept = end.y - line.slope*end.x
	}
	return line
}
