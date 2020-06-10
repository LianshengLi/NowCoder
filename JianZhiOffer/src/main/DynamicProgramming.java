package main;

public class DynamicProgramming {
    /**
     * 面试题63. 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     */
    int maxProfit = 0;
    int lowestDate = 0;
    public int maxProfit(int[] prices) {
        for(int i = 0; i < prices.length; i++){
            lowestDate = (prices[i] <= prices[lowestDate]) ? i : lowestDate;
            maxProfit = (prices[i]-prices[lowestDate] > maxProfit) ? prices[i]-prices[lowestDate] :             maxProfit;
        }
        return maxProfit;
    }

    /**
     * 面试题42. 连续子数组的最大和
     *
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     *
     * 要求时间复杂度为O(n)。
     * 示例1:
     *
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for(int i =0; i < nums.length; i++){
            tempSum += nums[i];
            maxSum = Math.max(maxSum, tempSum);
            //持续检测之前的序列的和 如果小于0 舍弃不保存 重置为0
            if(tempSum < 0){
                tempSum = 0;
            }
        }
        return maxSum;
    }

    
}
