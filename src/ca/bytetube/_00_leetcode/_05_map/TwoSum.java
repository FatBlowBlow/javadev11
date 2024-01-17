package ca.bytetube._00_leetcode._05_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;
        int[] nums = {3,2,3};
        int target = 6;
        int[] res = twoSum(nums, target);
        for (int i : res) {
            System.out.println(i);
        }
    }

    //hashmap
    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int a = nums[i];
            if(map.containsKey(target - a)){
                res[0] = i;
                res[1] = map.get(target - a);
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }

}
