package org.example.others;

import java.util.HashSet;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int k, int... nums) {
        if (nums.length < k) return 0;
        long max = 0;
        long s = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            s += nums[i];
            set.add(nums[i]);
        }
        if (set.size() == k) {
            max = s;
        }
        for (int i = 1; i < nums.length - k + 1; i++) {
            s = s - nums[i - 1];
            s = s + nums[i + k - 1];
            int j = i;
            boolean flag = false;
            while (j < i + k && set.size() < k) {
                if (nums[i - 1] == nums[j]) {
                    flag = true;
                    break;
                } else {
                    j++;
                }
            }
            if (!flag) {
                set.remove(nums[i - 1]);
            }
            set.add(nums[i + k - 1]);
            if (set.size() == k) {
                if (max < s) {
                    max = s;
                }
            }
        }
        return max;
    }
}
