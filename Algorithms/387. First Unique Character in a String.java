//https://leetcode.com/problems/first-unique-character-in-a-string/
/**
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 Note: You may assume the string contain only lowercase letters.

 */

class Solution {
    public int firstUniqChar(String s) {
        Map<String, Integer> words = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            Integer wordCount = words.get(character);
            words.put(character, wordCount == null ? 1: wordCount + 1);
        }
        for(Map.Entry<String,Integer> entry : words.entrySet()){
            if(entry.getValue() == 1){
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}