import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> currents = new ArrayList<ListNode>();
        for(int i=0; i<lists.length; i++){
            currents.add(lists[i]);
        }
        ListNode ans = null;
        ListNode current = null;
        while(!currents.isEmpty()){
            int smallest = Integer.MAX_VALUE;
            ListNode smallestNode = null;
            for(int i=0; i<currents.size(); i++){
                if(currents.get(i).val < smallest){
                    smallest = currents.get(i).val;
                    smallestNode = currents.get(i);
                }
            }
            if(ans == null){
                ans = smallestNode;
                current = ans;
            }
            else{
                current.next = smallestNode;
                current = current.next;
            }
            currents.remove(smallestNode);
            if(current.next != null) currents.add(current.next);
        }
        return ans;
    }
}
