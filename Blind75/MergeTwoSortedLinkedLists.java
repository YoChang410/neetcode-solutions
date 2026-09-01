/**
 * Definition for singly-linked list.
 */

//pass

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        System.out.println("test1");
        ListNode list1 = new ListNode(-9, new ListNode(3));
        ListNode list2 = new ListNode(5, new ListNode(7));
        System.out.println("test2");
        ListNode ans = mergeTwoLists(list1, list2);
        System.out.println("test3");
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode ans = null;

        if(list1 == null && list2 == null) return ans;
        if(list1 == null) return list2;
        if(list2 == null) return list1; 
        if(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ans = new ListNode(list1.val);
                list1 = list1.next;
            }
            else{
                ans = new ListNode(list2.val);
                list2 = list2.next;
            }
        }
        //System.out.println("is it getting past here?");
        ListNode current = ans;

        while(list1 != null || list2 != null){
            if(list1 == null){
                current.next = new ListNode(list2.val);
                list2 = list2.next;
                current = current.next;
            }
            else if(list2 == null){
                current.next = new ListNode(list1.val);
                list1 = list1.next;
                current = current.next;
            }
            else{
                if(list1.val < list2.val){
                    current.next = new ListNode(list1.val);
                    current = current.next;
                    list1 = list1.next;
                }
                else{
                    current.next = new ListNode(list2.val);
                    current = current.next;
                    list2 = list2.next;
                }
            }
        }
        
        return ans;
    }
}
