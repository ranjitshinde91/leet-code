package heap.merge_k_sorted_arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {


    public static ArrayList<Integer> mergeKArraysArrayBased(int[][] arr, int k)
    {
        ArrayList<Integer> mergedArray = new ArrayList<>();
        int[] indexes = new int[k];

        boolean allArraysTraversed = false;
        while(!allArraysTraversed){
            int arrayIndex = -1;
            int smallestValue = Integer.MAX_VALUE;
            for(int i=0;i<k;i++){
                if(indexes[i]< arr[i].length && arr[i][indexes[i]] < smallestValue){
                    smallestValue = arr[i][indexes[i]];
                    arrayIndex = i;
                }
            }
            if(arrayIndex != -1){
                mergedArray.add(smallestValue);
                indexes[arrayIndex] = indexes[arrayIndex]+1;
            }else{
                allArraysTraversed = true;
            }
        }
        return mergedArray;
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k)
    {
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(Element::value));
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<k;i++){
            pq.add(new Element(i,  0, arr[i][0]));
        }

        while(!pq.isEmpty()){
            Element e = pq.poll();
            list.add(e.value());
            if(e.columnIndex()< arr[e.arrayIndex()].length-1){
                pq.add(new Element(e.arrayIndex(), e.columnIndex()+1, arr[e.arrayIndex()][e.columnIndex()+1]));
            }
        }
        return list;
    }

    static class Element{
        private final int arrayIndex;
        private final int columnIndex;
        private final int value;


        public Element(int arrayIndex, int columnIndex, int value)
        {
            this.arrayIndex = arrayIndex;
            this.columnIndex = columnIndex;
            this.value = value;
        }

        public int arrayIndex(){
            return this.arrayIndex;
        }
        public int columnIndex(){
            return this.columnIndex;
        }
        public int value(){
            return this.value;
        }
    }

}
