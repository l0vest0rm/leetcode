package introduction.to.algorithm;

import com.google.gson.Gson;

/**
 * @program: leetcode
 * @author: xuning
 * @create: 2019-12-26
 * @description: 第四章-分治策略
 **/
public class Chapter7 {

  private Gson gson = new Gson();

  public static void main(String[] args) {
    //Gson gson = new Gson();
    Chapter7 solution = new Chapter7();
    int[] arr = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    solution.quickSort(arr);
    System.out.println(solution.gson.toJson(arr));
  }

  private void quickSort(int[] arr){
    quickSort(arr, 0, arr.length-1);
  }

  private void quickSort(int[] arr, int p, int r){
    if (p < r){
      int q = partition(arr, p, r);
      quickSort(arr, p, q-1);
      quickSort(arr, q+1, r);
    }
  }

  private int partition(int[] arr, int p, int r){
    int x = arr[r];
    int i = p -1;
    for (int j = p; j < r; j++) {
      if (arr[j] <= x) {
        i++;
        if (i != j) {
          exchange(arr, i, j);
        }
      }
    }

    exchange(arr, i+1, r);
    return i+1;
  }

  private void exchange(int[] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

}

