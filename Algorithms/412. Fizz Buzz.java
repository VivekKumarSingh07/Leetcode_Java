/** https://leetcode.com/problems/fizz-buzz/
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String value = "";
            value = concatFizz(i) + concatBuzz(i);
            if (value.isEmpty()) value = String.valueOf(i);
            result.add(value);
        }
        return result;
    }

    private String concatFizz(int n) {
        return n % 3 == 0 ? "Fizz" : "";
    }

    private String concatBuzz(int n) {
        return n % 5 == 0 ? "Buzz" : "";
    }
}
