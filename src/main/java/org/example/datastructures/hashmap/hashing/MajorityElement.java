package org.example.datastructures.hashmap.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MajorityElement {
    public static List<Integer> majority(int[] nums) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (numToCount.containsKey(nums[i])) {
                numToCount.put(nums[i], numToCount.get(nums[i]) + 1);
            } else {
                numToCount.put(nums[i], 1);
            }
        }
        List<Integer> majorityElements = new ArrayList<>();
        for (int key : numToCount.keySet()) {
            if (numToCount.get(key) >= n / 2) {
                majorityElements.add(key);
            }
        }
        return majorityElements;
    }
}
