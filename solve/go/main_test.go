package main

import (
	"fmt"
	"testing"
)

func TestP1(t *testing.T) {
	nums := []int{3, 3}
	target := 6
	ret := p1twoSum(nums, target)
	fmt.Println(ret)
}
