package CircularArray;

/**
 * @author HUSEYIN EMRE UGDUL
 * @since 3.11.2021
 */
public class CircularArray<E> {
    private E[] array;
    private int size;
    private int length;

    public CircularArray(int length) {
        this.length = length;
        array = (E[]) new Object[length];

    }
    public void insert(E value, int position){
        if(size == array.length){
            throw new IllegalArgumentException("Array is full.");
        }
        if (size == 0){
            array[position] = value;
            size++;
            return;
        }
        position %= size;
        for (int i = size; i >position ; i--) {
            array[i] = array[i-1];
        }
        array[position] = value;
        size++;
    }
    public void delete(int position){
        if (size == 0){
            throw new IllegalArgumentException("Array is empty");
        }
        position %= size;
        for (int i = position; i < array.length - 1 ; i++) {
            array[i] = array[i+1];
        }
        size--;

    }
    public void update(E value, int position){
        if (size == 0){
            throw new IllegalArgumentException("Array is empty.");
        }
        position %= size;
        array[position] = value;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(array[i]).append(" ");
        }
        return s.toString();
    }
    public static void main(String[] args) {

    }
}
