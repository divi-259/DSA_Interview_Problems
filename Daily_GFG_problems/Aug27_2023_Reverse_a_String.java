/*
Problem Link: https://practice.geeksforgeeks.org/problems/reverse-a-string/1

Problem Statement: You are given a string s. You need to reverse the string.

Solution Approach: 

*/

/* ------------CODE---------------- */
class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/