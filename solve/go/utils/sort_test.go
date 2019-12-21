package utils

import (
	"fmt"
	"testing"
)

func TestQsort(t *testing.T) {
	arr := []int{2, 7, 11, 11, 3, 15}
	QuickSort(arr)
	fmt.Println(arr)
}
