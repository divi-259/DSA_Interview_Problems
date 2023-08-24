/*
Problem Link: https://practice.geeksforgeeks.org/problems/multiply-two-strings/1

Problem Statement: 

Solution Approach: 

*/

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
       // removing leading zeros from both the strings
       int i = 0;
       boolean sign = false;
       if(s1.charAt(0)=='-' && s2.charAt(0)!='-')
        sign = true;
        else if(s1.charAt(0)!='-' && s2.charAt(0)=='-')
        sign= true;
        if(s1.charAt(i)=='-' || s1.charAt(i)=='+')
        i++;
       while(s1.charAt(i)=='0') {
           i++;
       }
       s1 = s1.substring(i, s1.length());
       i=0;
       if(s2.charAt(i)=='-' || s2.charAt(i)=='+')
        i++;
       while(s2.charAt(i)=='0') {
           i++;
       }
       s2 = s2.substring(i, s2.length());
       
       int m = s1.length(); int n = s2.length();
       String ans = "";
       
       // taking smaller string as multiplier, and larger string as multiplicant
       if(m<n) {
           ans = multiply(s1,s2, sign);
       }
       else ans = multiply(s2,s1, sign);
       
       return ans;
    }
    
    private String multiply(String a, String b, boolean sign) {
        // a's length is smaller than b's or they might be equal
        int m = a.length(); int n = b.length();
        // creating an array to store the strings formed in between which eventually need to be summed up
        String arr[] = new String[m];
        
        // picking one char at a time from end of a, and multiplying with string b
        for(int i=m-1; i>=0; i--) {
            int numa = Character.getNumericValue(a.charAt(i));
            int carry = 0;
            
            StringBuilder sb = new StringBuilder();
            
            int zcount = (m-1)-i; // the number of zeros to be appended at the string's end
            for(int in=0; in<zcount; in++) {
                sb.append('0');
            }
            
            for(int j=n-1; j>=0; j--) {
                int numb = Character.getNumericValue(b.charAt(j));
                int prod = numa*numb + carry;
                carry = prod/10;
                sb.insert(0, prod%10);
            }
            if(carry>0)
                sb.insert(0, carry);
            arr[m-1-i] = sb.toString();
        }
        
        // adding up all these strings to get our final answer 
        
        StringBuilder result = new StringBuilder();
        
        int maxLength = 0;
        for (String num : arr) {
            maxLength = Math.max(maxLength, num.length());
        }
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int digitSum = carry;
            //System.out.println(carry);
            for (String num : arr) {
                //System.out.println(num);
                if (num.length() > i) {
                    int digitValue = num.charAt(num.length() - 1 - i) - '0';
                    digitSum += digitValue;
                }
            }

            carry = digitSum / 10;
            result.insert(0, digitSum % 10);
        }
        //System.out.println(carry);
        if (carry > 0) {
            result.insert(0, carry);
        }
        if(sign)
            result.insert(0, '-');
        
        return result.toString();
    }
}