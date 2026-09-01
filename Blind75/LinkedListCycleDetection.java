import java.util.HashSet;
//pass
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<ListNode>();
        while(head != null){
            if(seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
    }
}
