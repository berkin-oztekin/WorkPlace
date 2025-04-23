public class QuickSort {
    public static void main(String [] args){
        int [] array = {3 , 2, 5 ,0 , 1, 8 ,7 ,6 , 9 , 4 };
        int pointer1 =  -1  ;
        int idle =  0 ;

        int pivot = array.length - 1 ;

        for(int pointer2 = 0 ; pointer2 < array.length  ; pointer2++){
            if ( array[pointer2] > array[pivot]){
                continue;
            }
            if ( array[pointer2] <= array[pivot]){
                pointer1++;
                if(pointer2 > pointer1){
                    idle  = array[pointer1];
                    array[pointer1] = array[pointer2];
                    array[pointer2] = idle;
                }
                if(array[pointer2] == array[pointer1])
                    continue;
            }

        }

    }

}
