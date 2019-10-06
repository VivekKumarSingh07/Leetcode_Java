//https://leetcode.com/problems/zigzag-conversion/description/

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
//of rows like this: (you may want to display this pattern in a fixed font for
//better legibility)

//P   A   H   N
//A P L S I I G
//Y   I   R

//And then read line by line: "PAHNAPLSIIGYIR"

//Write the code that will take a string and make this conversion given a
//number of rows:

//string convert(string s, int numRows);

//Example 1:

//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"


//Example 2:

//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:

//P   A   H   N
//A P L S I I G
//Y   I   R

//Solution

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int cycle = 2 * (numRows - 1);
        StringBuffer output = new StringBuffer();

        int row = 0;
        while(row < numRows) {
            boolean isEven = true;
            int firstStep = cycle - row * 2 % cycle;
            int secondStep = row * 2 - cycle % cycle;
            firstStep = firstStep == 0 ? cycle : firstStep;
            secondStep = secondStep == 0 ? cycle : secondStep;

            int i = 0;
            while (row + i < s.length()) {
                output.append(s.charAt(row + i));
                i += isEven ? firstStep : secondStep;
                isEven = !isEven;
            }

            row++;
        }

        return output.toString();
    }
}