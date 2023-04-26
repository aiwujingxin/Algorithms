package hot100

//https://www.youtube.com/watch?v=i4gGVvhmLds
func hammingDistance(x int, y int) int {
	s := x ^ y
	ret := 0
	for s != 0 {
		ret += s & 1
		s >>= 1
	}
	return ret
}
