package introduction.to.algorithm;

import leetcode.p001.Solution;

import java.util.Arrays;
import com.google.gson.Gson;

/**
 * @program: leetcode
 * @author: xuning
 * @create: 2019-12-26
 * @description: 第四章-分治策略
 **/
public class Chapter4 {

  public static void main(String[] args) {
    Gson gson = new Gson();
    Chapter4 solution = new Chapter4();
    int[] arr = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    System.out.println(gson.toJson(solution.findMaxSubArray(arr)));
  }

  private Result findMaxSubArray(int[] arr) {
    if (arr.length == 0) {
      return new Result(0, 0, 0);
    }

    return findMaxSubArray(arr, 0, arr.length - 1);
  }

  private Result findMaxSubArray(int[] arr, int low, int high) {
    if (low == high) {
      return new Result(low, high, arr[low]);
    }

    int mid = (low + high)/2;
    Result rLeft = findMaxSubArray(arr, low, mid);
    Result rRight = findMaxSubArray(arr, mid + 1, high);
    Result rCross = findMaxCrossSubArray(arr, low, mid, high);

    if (rLeft.sum >= rRight.sum && rLeft.sum >= rCross.sum) {
      return rLeft;
    }else if (rRight.sum >= rLeft.sum && rRight.sum >= rCross.sum) {
      return rRight;
    }else  {
      return rCross;
    }
  }

  private Result findMaxCrossSubArray(int[] arr, int low, int mid, int high) {
    int sum = 0;
    int maxLeft = mid;
    int maxRight = mid + 1;
    int leftSum = Integer.MIN_VALUE;
    int rightSum = Integer.MIN_VALUE;
    for (int i = mid; i >= low; i--){
      sum += arr[i];
      if (sum > leftSum) {
        leftSum = sum;
        maxLeft = i;
      }
    }

    sum = 0;
    for (int i = mid + 1; i <= high; i++){
      sum += arr[i];
      if (sum > rightSum) {
        rightSum = sum;
        maxRight = i;
      }
    }

    return new Result(maxLeft, maxRight, leftSum + rightSum);
  }

}

class Result {
  int low;
  int high;
  int sum;

  public Result( int low, int high, int sum){
    this.low = low;
    this.high = high;
    this.sum = sum;
  }
}