
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode current = head;
        while(current != null){
            nodes.add(current);
            current = current.next;
        }
        if(n == nodes.size())return head.next;
        current = nodes.get(nodes.size() - n - 1);
        current.next = current.next.next;
        return head;
    }
}
