package LeetCodeExercies;

public class SearchInsertPosition {
    public static void main(String [] args){
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums , 7));


    }
    public static int searchInsert(int[] nums, int target) {

        int mid = (nums.length / 2)   ;
        int mid_Value = nums[mid];

        if(mid_Value == target)
            return mid;

        if(mid_Value > target){
            for(int i = mid ; i >= 0 ; i--){
                if(nums[i] == target)
                    return i;

                if (nums[i] < target)
                    return  i + 1;

                if(i == 0)
                    return 0 ;

            }
        }

        if(mid_Value < target){
            for(int i = mid ; i < nums.length ; i++){
                if(nums[i] == target){
                    return i;
                }

                if (nums[i] > target){
                    return  i ;
                }

                if(i == nums.length - 1)
                    return i + 1 ;
            }
        }
        return 0 ;
    }
}
