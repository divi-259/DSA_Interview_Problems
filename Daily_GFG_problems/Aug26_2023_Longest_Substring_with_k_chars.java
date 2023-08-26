/*
Problem Link: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

Problem Statement: Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Solution Approach: 
Use sliding window approach to traverse the string and keep a variable msxlen to store the length of max string with k distinct chars

*/

/* ------------CODE---------------- */
class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        
        // Hashmap to store the characters in the current window with their frequency
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        //length to store for the largest string 
        int maxlen = -1;
        
        // starting with sliding window
        int i=0, j=0;
        
        while(i<=j && j<n) {
            
            while(j<n && hmap.size()<=k) {
                char ch = s.charAt(j);
                hmap.put(ch, hmap.getOrDefault(ch,0)+1);
                j++;
            }
            
            if(hmap.size()==k)
            {
                //System.out.println("here");
                maxlen = Math.max(j-i, maxlen);
            }
            if(hmap.size() > k) {
                j--;
                hmap.remove(s.charAt(j));
                maxlen = Math.max(j-i, maxlen);
            }
            //System.out.println(s.substring(i,j));
            
            while(i<=j && hmap.size()==k) {
                char ch = s.charAt(i);
                hmap.put(ch, hmap.getOrDefault(ch,0)-1);
                if(hmap.get(ch)==0)
                    hmap.remove(ch);
                i++;
            }
            
        }
        return maxlen;
        
       
    }
}

/*
Time Complexity:  O(n) - where n is the length of the string, as we are using sliding window to traverse the string
Space Complexity: O(k)  - we are using hashmap and it can store elements upto the length of the k
*/