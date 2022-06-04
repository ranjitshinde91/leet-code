package heap.min_heap;


public class MinHeap {

    private final int capacity;
    private final int[] array;
    private int size = 0;


    MinHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public MinHeap(int[] ints) {
        this.capacity = ints.length;
        this.array = ints;
        this.size = ints.length;
    }

    public int size() {
        return this.size;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int insert(int element) {
        array[size] = element;
        rearrange(size);
        size++;
        return size;
    }

    public void rearrange(final int i) {
        int index = i;
        while (index > 0 && array[parent(index)] > array[index]) {
            int temp = array[index];
            array[index] = array[parent(index)];
            array[parent(index)] = temp;
            index = parent(index);
        }
    }

    public int[] values() {
        var temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        return temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void heapify(int index) {

        int left = left(index);
        int right = right(index);

        int smallest = index;
        if (left < size && array[left] < array[index]) {
            smallest = left;
        }
        if (right < size && array[right] < array[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            int temp = array[smallest];
            array[smallest] = array[index];
            array[index] = temp;

            heapify(smallest);
        }
    }

    public int getMin(){
        if(size()>0){
            return array[0];
        }
        return -1;
    }

    public int deleteMin(){
        if(size == 0){
            return -1;
        }
        if(size ==1){
            size--;
            return array[0];
        }
        int min = array[0];
        array[0] = array[size-1];
        size--;
        heapify(0);
        return min;
    }

    public void decreaseKey(int index, int newValue){
        array[index] = newValue;
        rearrange(index);
    }

    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        deleteMin();
    }
}