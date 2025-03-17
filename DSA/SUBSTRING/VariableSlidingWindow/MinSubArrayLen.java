package java_collection.DSA.SUBSTRING.VariableSlidingWindow;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int S = 7;
        int result = minSubArrayLen(S, nums);
        System.out.println("Minimum subarray length: " + result);
    }

    public static int minSubArrayLen(int S, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int maxSum = 0;

        for (int end = 0; end < nums.length; end++) {
            maxSum += nums[end];
            while (maxSum >= S) {
                minLength=Math.min(minLength,end-start+1);
                maxSum-=nums[start];
                start++;
            }
        }
        return minLength;
    }
}
