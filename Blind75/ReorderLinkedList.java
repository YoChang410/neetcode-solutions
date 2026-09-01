import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReorderLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReorderLinkedList test = new ReorderLinkedList();
        test.reorderList(head);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        ListNode current = head;
        boolean LorR = true;
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        while(current != null){
            nodes.add(current);
            current = current.next;
        }
        current = head;
        int L = 1;
        int R = nodes.size()-1;
        while(L<=R){
            if(LorR){
                current.next = nodes.get(R);
                R--;
            }
            else{
                current.next = nodes.get(L);
                L++;
            }
            current = current.next;
            LorR = !LorR;
        }
        current.next = null;
    }
}
