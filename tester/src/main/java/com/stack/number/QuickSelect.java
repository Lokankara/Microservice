package com.stack.number;

public class QuickSelect {

    private QuickSelect(){}
    public static double findMedian(int[] nums) {
        int n = nums.length;

        return (quickSelect(nums, 0, n - 1, (n + 1) / 2)
                + quickSelect(nums, 0, n - 1, (n + 2) / 2)) / 2.0;
    }

    private static int quickSelect(
            int[] nums,
            int left,
            int right,
            int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right, getPivotIndex(left, right));

        if (k - 1 == pivotIndex) {
            return nums[pivotIndex];
        } else if (k - 1 < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int getPivotIndex(int left, int right) {
        return (left + right) / 2;
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(
            int[] nums,
            int i,
            int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
