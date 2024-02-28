package com.stack.kata;

public class Permutation {

    public int[] buildArray(int[] nums) {
        transformArray(nums, 0);
        return nums;
    }

    private void transformArray(int[] nums, int i) {
        if (i < nums.length) {
            int num = nums[nums[i]];
            transformArray(nums, i + 1);
            nums[i] = num;
        }
    }

    public int[] concatenateArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        System.arraycopy(nums, 0, result, 0, n);
        System.arraycopy(nums, 0, result, n, n);
        return result;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }
}
