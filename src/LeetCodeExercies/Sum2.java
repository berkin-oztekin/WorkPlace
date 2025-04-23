package LeetCodeExercies;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum2 {
    public static void main(String[] args) {
        int [] deneme = {3,2,4};
        System.out.println(Arrays.toString(twoSum(deneme, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] list = new int[2];

        for (int i = 0; i < nums.length ; i++) {
            for (int x = 0; x < nums.length ; x++) {
                int sum = nums[i] + nums[x];
                if (i == x) {
                    continue;
                }else if(target == sum){
                    list[0] = i;
                    list[1] = x ;
                }
            }
        }
        return list;
    }
}
