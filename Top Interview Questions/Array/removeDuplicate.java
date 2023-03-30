class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		// System.out.println("hello");

		if (nums.length <= 1) {
			return nums.length;
		}

		int result = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[result] = nums[i];
				result++;
			}
		}
		return result;
	}
}
/*
 * 
 * 11133223
 * ^
 * nums[1] == num[0] result = 1
 * 
 * 11133223
 * ^
 * nums[2] == num[1] result = 1
 * 
 * 11133223
 * ^
 * nums[3] == num[2] result = 1
 * 
 * 11133223
 * ^
 * nums[4] != num[3] result = 2
 * nums[2] = nums[4]
 * nums[result] = nums[i]
 * 
 * 11133223
 * ^
 * nums[5] == num[4] result = 2
 * 
 * 
 */
