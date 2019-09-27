//https://leetcode.com/problems/longest-substring-without-repeating-characters/

//Given a string, find the length of the longest substring without repeating characters.

//Example

//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//Solution
class Solution {
	public int lengthOfLongestSubstring(String s) {

		List<Character> alphabet = new ArrayList<>();
		int counter = 0;
		int max = 0;

		for(int i = 0; i < s.length(); i++)
		{
			for(Character c : s.substring(i, s.length()).toCharArray())
			{
				if(!alphabet.contains(c))
				{
					alphabet.add(c);
					counter++;

					if(counter > max)
					{
						max = counter;
					}
				}
				else
				{
					alphabet.clear();
					counter = 0;
					break;
				}
			}

			if(max >= s.length() - i)
			{
				return max;
			}
		}

		return max;
	}
}