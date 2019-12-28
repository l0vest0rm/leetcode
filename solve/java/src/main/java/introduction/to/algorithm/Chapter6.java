package introduction.to.algorithm;

import com.google.gson.Gson;

/**
 * @program: leetcode
 * @author: xuning
 * @create: 2019-12-26
 * @description: 第四章-分治策略
 **/
public class Chapter6 {

  private Gson gson = new Gson();

  public static void main(String[] args) {
    //Gson gson = new Gson();
    Chapter6 solution = new Chapter6();
    int[] arr = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    solution.heapSort(arr);
    System.out.println(solution.gson.toJson(arr));
  }

  private void maxHeapify(int[] arr, int maxPos, int i){
    int left = i * 2 + 1;
    int right = i * 2 + 2;
    int largest = i;

    if (left <= maxPos && arr[left] > arr[i]) {
      largest = left;
    }

    if (right <= maxPos && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      int tmp = arr[largest];
      arr[largest] = arr[i];
      arr[i] = tmp;
      maxHeapify(arr, maxPos, largest);
    }
  }

  private void buildMaxHeap(int[] arr) {
    for (int i = arr.length/2 - 1; i >= 0; i--) {
      maxHeapify(arr, arr.length-1, i);
    }
  }

  private void heapSort(int[] arr) {
    buildMaxHeap(arr);
    System.out.println(gson.toJson(arr));
    for (int i = arr.length-1; i > 0; i--) {
      int tmp = arr[0];
      arr[0] = arr[i];
      arr[i] = tmp;
      maxHeapify(arr, i-1, 0);
    }

  }

}

