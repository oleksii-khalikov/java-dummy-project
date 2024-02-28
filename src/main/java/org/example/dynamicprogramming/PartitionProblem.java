/**
 * @author Md Asif Joardar
 *
 * Description: The partition problem is a classic problem in computer science
 * that asks whether a given set can be partitioned into two subsets such that
 * the sum of elements in each subset is the same.
 *
 * Example:
 * Consider nums = {1, 2, 3}
 * We can split the array "nums" into two partitions, where each having a sum of 3.
 * nums1 = {1, 2}
 * nums2 = {3}
 *
 * The time complexity of the solution is O(n × sum) and requires O(n × sum) space
 */

package org.example.dynamicprogramming;

import java.util.Arrays;

public class PartitionProblem {

    public static boolean partition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return (sum & 1) == 0 && SubsetSum.subsetSum(nums, sum / 2);
    }
}
