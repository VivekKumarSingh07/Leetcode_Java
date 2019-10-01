class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] novoArray = new int[2];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j ++) {
				if(nums[i] + nums[j] == target && i!=j) {
					novoArray[0] = nums[i];
					novoArray[1] = nums[j];
					return novoArray;
				}
			}
		}
		return novoArray;
	}
        
}
