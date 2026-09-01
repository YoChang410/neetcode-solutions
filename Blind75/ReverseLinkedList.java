/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//pass
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reversed = reverseLinkedList.reverseList(head);
        while(reversed != null){
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode realCurrent = head;
        ListNode current = null;
        while(realCurrent != null){
            current = new ListNode(realCurrent.val);
            if(previous != null)current.next = previous;
            previous = current;
            realCurrent = realCurrent.next;
        }
        return current;
    }
}
