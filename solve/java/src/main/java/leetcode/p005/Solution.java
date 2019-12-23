package leetcode.p005;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    //System.out.println(Arrays.toString(solution.twoSum(nums, target)));
  }

  public String longestPalindrome(String s) {
    int start = 0,end = 0;
    for (int i = 0; i < s.length(); i ++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i+1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    if (right > s.length()) {
      return 0;
    }

    int L = left;
    int R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }

    return R - L + 1;
  }

}
