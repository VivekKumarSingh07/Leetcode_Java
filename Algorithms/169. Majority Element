//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
//
//Example 1:
//
//Input: [3,2,3]
//Output: 3
//Example 2:
//
//Input: [2,2,1,1,1,2,2]
//Output: 2

public class MajorityNumber {
	public static void main(String[] args) {
		int[] array = {1,2,3,3,3,2,4, 4, 4, 4, 4};
		System.out.println(majority(array));
	}

	public static int majority(int[] array) {
		int maior =  -999999;
		int cont = 0;
		int majorityNumer = -999999;
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if (array[i] == array[j] && i != j) {
					cont += 1;
				}
			}
			if (cont > maior) {
				maior = cont;
				majorityNumer = array[i];
			}
			cont = 0;
		}
		return majorityNumer;
	}
}
