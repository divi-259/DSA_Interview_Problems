/*
Problem Link: https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1

Problem Statement: Given a singly linked list and an integer x.Delete xth node from the singly linked list.

Solution Approach: 
Keep a counter variable, and keep two nodes prev and curr to move along the list, as soon as the counter becomes
equal to x, set the next pointer of prev to the next pointer of current, and return head.

*/

/* ------------CODE---------------- */
class GfG
{
    Node deleteNode(Node head, int x)
    {
	 
	  if(head==null)
	  return head;
	  
	  if(x==1)
	  return head.next;
	  
	  Node prev = head;
	  Node curr = head.next;
	  int count = 1;
	  
	  while(curr!=null) {
	      count++;
	      if(count==x)
	      {
	          prev.next = curr.next;
	          return head;
	      }
	      else {
	          prev = prev.next;
	          curr = curr.next;
	      }
	  }
	  
	  return head;
	  
	  
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/