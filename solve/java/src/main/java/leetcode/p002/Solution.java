package leetcode.p002;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode head = new ListNode(0);
    ListNode pos = head;

    while (p1 != null || p2 != null) {
      if (p1 != null){
        carry += p1.val;
        p1 = p1.next;
      }

      if (p2 != null) {
        carry += p2.val;
        p2 = p2.next;
      }

      pos.val = carry % 10;
      carry = carry / 10;
      if (p1 != null || p2 != null || carry > 0) {
        pos.next = new ListNode(carry);
      }

      pos = pos.next;
    }

    return head;
  }


}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
