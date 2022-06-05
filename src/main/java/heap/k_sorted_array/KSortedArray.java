package heap.k_sorted_array;

import java.util.PriorityQueue;

public class KSortedArray {


    public void sortNaive(int[] input, int k, int n) {
        for(int i=0;i<n;i++){
            int smallestValueIndex = 0;
            if(i+k>=n){
                smallestValueIndex= findSmallestValueIndex(input, i, n-1);
            }else{
                smallestValueIndex= findSmallestValueIndex(input, i, i+k);
            }
            swap(input, i , smallestValueIndex);
        }
    }

    private int findSmallestValueIndex(int[] array, int index, int n){
        int smallestValueIndex= index;
        for( int i = index; i<=n; i++){
            if(array[i]< array[smallestValueIndex]){
                smallestValueIndex = i;
            }
        }
        return smallestValueIndex;

    }

    private void swap(int[] array, int i, int j){
        int temp =array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(int[] input, int k, int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<=k;i++){
            pq.add(input[i]);
        }
        int index=0;

        for(int i=k+1;i<n;i++)
        {
            input[index++] = pq.poll();
            pq.add(input[i]);
        }
        while(!pq.isEmpty()){
            input[index++] = pq.poll();
        }
    }

}
