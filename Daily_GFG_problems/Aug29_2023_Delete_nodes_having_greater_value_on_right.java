/*
Problem Link: https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1

Problem Statement: Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. (Not just immidiate Right , but entire List on the Right)

Solution Approach: Reverse the list, then keep picking up the largest elements in the list and then return the reversed list again.

*/

/* ------------CODE---------------- */
class Solution
{
    Node compute(Node head)
    
    {
        // your code here
        if(head==null || head.next==null)
            return head;
        
        head = reverse(head);
        
        Node temp = head; int max = head.data;
        
        while(temp!=null) {
            Node next = temp.next;
            while(next != null && max > next.data) next = next.next;
            if(next != null) max = Math.max(max, next.data);
            temp.next = next;
            temp = temp.next;
        }
        return reverse(head);

    }
    
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = head;
        
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
  

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/