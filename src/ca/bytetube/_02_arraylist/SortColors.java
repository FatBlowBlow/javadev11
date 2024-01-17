package ca.bytetube._02_arraylist;

/**
 * https://leetcode.com/problems/sort-colors/
 */

public class SortColors {


    public void sortColors(int[] nums) {
            int less = -1;
            int more = nums.length;
            int cur = 0;
            while (cur < more){//循环结束时：cur=pivot
                if (nums[cur] < 1) {
                    swap(nums, ++less, cur++);

                }else if (nums[cur] > 1){
                    swap(nums, --more, cur);

                }else {
                    cur++;
                }

            }

        }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    }

