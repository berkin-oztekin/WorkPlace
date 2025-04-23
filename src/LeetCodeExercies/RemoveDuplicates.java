package LeetCodeExercies;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String [] args){
        int [] array = {1 , 2 ,3 , 4 , 5 , 6 , 7 , 8, 9 };

        removeDuplicates(array);
    }



    public static int removeDuplicates(int[] nums) {
        int counter = 0 ;
        if (nums.length == 0)
            return 0;

        for(int i = 1  ;  i < nums.length ; i ++){
            if(nums[counter] == nums[i])
                continue;
        counter++;
        nums[counter] = nums[i];
        }

        return counter + 1 ;



/*
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

 */




    }

}
