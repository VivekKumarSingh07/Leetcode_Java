//https://leetcode.com/problems/defanging-an-ip-address/
/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

 

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"

 

Constraints:

    The given address is a valid IPv4 address.
*/


class Solution {
    public String defangIPaddr(String address) {
        String s = address;
        int t = s.length();
        String s1="";
        for(int i=0; i<t; i++)
        {
            char x = s.charAt(i);
            if(x=='.')
                s1=s1+"[.]";
            else
                s1=s1+x;
            
        }
        return s1;
        
    }
}