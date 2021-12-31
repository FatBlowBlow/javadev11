package ca.bytetube._14_divide;

public class MaxSubArray {
    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        maxSubArray(nums, 0, nums.length);

        return 0;

    }

    public int maxSubArray(int[] nums, int begin, int end){

        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) >> 1;

        //1.maxSubArray在[begin, mid)
        int leftMax = maxSubArray(nums,begin, mid);

        //2.maxSubArray在[mid, nums.length--->end)
        int rightMax = maxSubArray(nums,mid, nums.length);
        int max = Math.max(leftMax,rightMax);

        //3.maxSubArray在[begin, mid) + [mid, nums.length)
        int leftSum = 0;
        int lMax = Integer.MIN_VALUE;
        for (int i = mid - 1; i >= begin; i--){
            leftSum += nums[i];
            lMax = Math.max(lMax,leftSum);
        }

        int rightSum = 0;
        int rMax = Integer.MIN_VALUE;
        for (int i = mid; i < end; i++){
            rightSum += nums[i];
            rMax = Math.max(rMax,rightSum);
        }

        return Math.max(lMax + rMax,max);
    }


    public int maxSubArray1(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++){
            for (int end = begin; end < nums.length; end++){
                //需要把从begin开始到end结束这个区间范围内所有的数据进行相加
                int sum = 0;
                for(int i = begin; i <= end; i++){
                    sum += nums[i];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }


    public int maxSubArray2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++){
            int sum = 0;
            for (int end = begin; end < nums.length; end++){
                //需要把从begin开始到end结束这个区间范围内所有的数据进行相加
                sum += nums[end];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

}
