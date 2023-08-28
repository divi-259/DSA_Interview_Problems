/*
Problem Link: https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1

Problem Statement: Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the given list (if exists).
Note: Try not to use extra space. The nodes are arranged in a sorted way.

Solution Approach: Take prev and temp variable, if there is any duplicate movre prev.next one ahead.

*/

/* ------------CODE---------------- */
class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here	
	    if(head==null || head.next==null)
	    return head;
	    Node temp = head.next;
	    Node prev = head;
	    while(temp!=null) {
	        if(temp.data==prev.data) {
	            prev.next = temp.next;
	            temp = prev.next;
	        }
	        else {
	            prev = prev.next;
	            temp = temp.next;
	        }
	    }
	    return head;
    }
}


/*
Time Complexity: O(n)
Space Complexity: O(1) - we are doing changes in the same list
*/