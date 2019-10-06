//https://leetcode.com/problems/valid-number/

//Problem statement: Validate if a given string can be interpreted as a decimal number.

/*Examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false*/

//Solution:
class Solution {
    public boolean isNumber(String s) {
       
        if(s.indexOf('f') != -1 || s.indexOf('d') != -1 || s.indexOf('F') != -1 || s.indexOf('D') != -1){
            return false;
        }
        
        else{
            
            try{
                Double.parseDouble(s);
                return true;
            }
            
            catch(NumberFormatException e){
                return false;
            }
        }
        
    }
}