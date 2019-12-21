package utils

// QuickSort  快速排序
func QuickSort(arr []int) {
	quickSort(arr, 0, len(arr)-1)
}

// 快速排序[i,j)范围，flag为i
func quickSort(arr []int, start, end int) {
	if start >= end {
		return
	}

	i, j := start, end
	key := arr[(start+end)/2]

	for i <= j {
		for arr[i] < key {
			i++
		}

		for arr[j] > key {
			j--
		}

		if i <= j {
			arr[i], arr[j] = arr[j], arr[i]
			i++
			j--
		}

		if start < j {
			quickSort(arr, start, j)
		}

		if end > i {
			quickSort(arr, i, end)
		}

	}
}
