package practice;

public class MaxMirror {

	public static void main(String[] args) {
		int[] arr;
		arr = new int[] { 1, 2, 1, 4 };// int [] arr= {1, 2, 3, 8, 9, 3, 2, 1};
		System.out.println(maxMirror(arr));
		// ArrayTools.arrayToPrint(maxMirror(arr));
	}

	public static int maxMirror(int[] nums) {
		int revOrder[] = new int[nums.length];
		int max = 0;
		int currentMax = 0;
		for (int i = nums.length - 1; i > -1; i--) {
			revOrder[nums.length - 1 - i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i > 0 && j > 0) {
					if (revOrder[j] == nums[i] && revOrder[j - 1] == nums[i - 1]) {
						currentMax++;
					} else if (revOrder[j] == nums[i] && revOrder[j - 1] != nums[i - 1]) {
						currentMax = 1;
					} else {
						currentMax = 0;
					}
				} else {
					if (revOrder[j] == nums[i]) {
						currentMax = 1;
					} else {
						currentMax = 0;
					}
				}
				if (currentMax > max) {
					max = currentMax;
				}
				if (currentMax == 0) {
					break;
				}
				if (currentMax > 0 && i < nums.length - 1) {
					i++;
				}
			}
		}
		return max;
		}

}
