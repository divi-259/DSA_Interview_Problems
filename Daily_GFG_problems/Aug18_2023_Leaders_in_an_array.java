/*
Problem Link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

Problem Statement: Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.

Solution Approach: We can start traversing the array from the right to left, and we need to keep track of the max number so far. 
If the given number is greater than max so far - then add it to the ans array as it is the leader, and update the max element.

*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    

		    for(int i=0; i<res.size(); i++){
		        ot.print(res.get(i)+" ");
		    }
		    
		    ot.println();
		}
		ot.close();
		
	}
}

// } Driver Code Ends


class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0,arr[n-1]); // last number will always be leader as there are no numbers after this number
        
        int maxsofar = arr[n-1];
        
        for(int i=n-2; i>=0; i--) {
            if(arr[i] >= maxsofar) {
                ans.add(0, arr[i]);
            }
            maxsofar = Math.max(maxsofar, arr[i]);
        }
        return ans;
    }
}
