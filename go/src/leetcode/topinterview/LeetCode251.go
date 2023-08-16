package topinterview

type Vector2D struct {
	vector [][]int
	i      int
	j      int
}

func ConstructorVector2D(vec [][]int) Vector2D {
	return Vector2D{
		vector: vec,
		i:      0,
		j:      0,
	}
}

func (this *Vector2D) Next() int {
	if this.j > len(this.vector[this.i])-1 {
		this.i++
		for this.i < len(this.vector) && len(this.vector[this.i]) == 0 {
			this.i++
		}
		this.j = 0
	}
	num := this.vector[this.i][this.j]
	this.j++
	return num
}

func (this *Vector2D) HasNext() bool {
	row := this.i
	col := this.j
	if len(this.vector) == 0 {
		return false
	}
	if len(this.vector[row]) > 0 && col < len(this.vector[row])-1 {
		return true
	}
	if col > len(this.vector[row])-1 {
		row++
		for row < len(this.vector) && len(this.vector[row]) == 0 {
			row++
		}
		col = 0
	}
	if row == len(this.vector) {
		return false
	}
	return true
}
