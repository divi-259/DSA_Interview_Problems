/*
Problem Link: https://practice.geeksforgeeks.org/problems/palindrome-string0817/1

Problem Statement: Given a string S, check if it is palindrome or not.


Solution Approach: Get the reverse and check with original, or take two pointers on two ends of the string and compare the chars.

*/

/* ------------CODE---------------- */

class Solution {
    int isPalindrome(String S) {
        // code here
        StringBuilder sb = new StringBuilder(S);
        String rev = sb.reverse().toString();
        return S.equals(rev)? 1 : 0;
    }
};

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/