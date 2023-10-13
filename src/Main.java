import javax.print.attribute.standard.PageRanges;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}


// mine, revised. pass 35/55
//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        ListNode swap = head;
//        ListNode temp = head;
//        ListNode connector = new ListNode();
//        head = head.next;
//
//        while(swap.next != null){
//            connector = swap;
//            temp = swap.next;
//            swap.next = swap.next.next;
//            temp.next = swap;
//            swap = swap.next;
//            if(swap != null) {
//                connector.next = swap.next;
//            }
//        }
//        return head; // problem is head was 1 so no preciding info also totally missing 2 and 4. want a whiteboard...
//    }
//}

/*
1,2,3,4

head = 1
swap = 1
temp = 1
connector = new
head = 2

it 1
con = 1
swap = 1
temp = 2
1 point 3
2 points 1
swap = 3
1 points to 4

2-> 1 -> 3 -> 4

it 2
connector = 3
swap = 3
temp = 4
3 points null
4 points 3
swap = null
connector doees not update

return 2 since we alrady know 2nd node in list will become thee new head after all swaps



2-> 1 -> 3 -> null
    4 -> 3 nbut nothing points to 4
    need a trailing var that = swap before it gets changed

 */