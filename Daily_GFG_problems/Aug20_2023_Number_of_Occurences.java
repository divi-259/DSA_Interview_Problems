/*
Problem Link: https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1

Problem Statement: Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Solution Approach: Traverse the array and count the occurences of the number.

*/

/* ------------CODE---------------- */

class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==x)
            count++;
        }
        return count;
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
