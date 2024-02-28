package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Array {

    /**
     * https://leetcode.com/problems/two-sum/submissions/1179601593/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< nums.length; i++) {
            int x = target - nums[i];

            if (map.containsKey(x)) {
                return new int[] {i, map.get(x)};
            }

            map.put(nums[i], i);
        }

        return null;
    }


    /**
     * https://leetcode.com/problems/two-sum/submissions/1179601593/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
                continue;
            }

            profit = Integer.max(prices[i] - buyPrice, profit);
        }

        return profit;
    }

    /**
     * https://leetcode.com/problems/contains-duplicate/
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], false);
        }

        return false;
    }

    /**
     * 238. Product of algorithms.Array Except Self
     *
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Example 2:
     *
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] productArray = new int[nums.length];
        int productResult = 1;
        productArray[0] = productResult;
        for (int i = 1; i < nums.length; i++) {
            productResult *= nums[i - 1];
            productArray[i] = productResult;

        }

        int reverseProductResult = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            reverseProductResult *= nums[i + 1];
            productArray[i] *= reverseProductResult;
        }

        return productArray;
    }

    /**
     * https://leetcode.com/problems/maximum-subarray/description/
     *
     * 53. Maximum Subarray
     *
     * Given an integer array nums, find the
     * subarray
     *  with the largest sum, and return its sum.
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     *
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     *
     * Example 3:
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maximumSum = Math.max(currentSum, maximumSum);
            currentSum = Math.max(currentSum, 0);
        }

        return maximumSum;
    }

    /**
     * https://leetcode.com/problems/maximum-product-subarray/
     *
     * 152. Maximum Product Subarray
     *
     * Given an integer array nums, find a subarray that has the largest product, and return the product.
     * The test cases are generated so that the answer will fit in a 32-bit integer.
     *
     * Example 1:
     *
     * Input: nums = [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     *
     *  Example 2:
     *
     * Input: nums = [-2,0,-1]
     * Output: 0
     *
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 뒤로 갈 수록 숫자는 커진다. (0이 없다면)

        int currentProduct = 1;
        int maximumProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentProduct *= nums[i];
            maximumProduct = Math.max(currentProduct, maximumProduct);
            if (currentProduct == 0) {
                currentProduct = 1;
            }
        }

        return maximumProduct;
    }

    /**
     * https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
     *
     * 605. Can Place Flowers
     *
     * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
     *
     * Example 1:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: true
     *
     * Example 2:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: false
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;

            if (i > 0 && flowerbed[i - 1] == 1) {continue;}
            if (flowerbed[i] == 1) {i++; continue;}
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {i+=2; continue;}

            i++;
            n--;
        }

        return false;
    }
}