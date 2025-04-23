import java.util.Arrays;

public class DynamicArray {
    private int data[];
    private int size;
    private static int capacity;

    public DynamicArray() {
        int[] array = new int[2];
        size=0;
        capacity=2;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getIndex(int index){
        return  data[index];
    }

    // boş index yoksa kapasite arttıralacak.
    private void increaseCapacity(int newSize){
        int oldCapacity = getCapacity();

        if(oldCapacity < newSize) {
            int newCapacity = oldCapacity * 2;

            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
    }

    // son indexe eleman eklemek
    public int addElement(int element){
        if (size == capacity){
            increaseCapacity(size + 1);
        }

        data[size] = element;
        return size++;
    }
    public static void main(String [] args){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.increaseCapacity(4);
        System.out.println();
    }
}
