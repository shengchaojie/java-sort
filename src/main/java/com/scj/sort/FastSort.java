package com.scj.sort;

/**
 * Created by shengchaojie on 2018/8/7.
 */
public class FastSort extends AbstractSort{


    public void sort(int[] source) {
        quickSort(source,0,source.length-1);
    }

    public void quickSort(int[] source,int start,int end){
        if(start<end){
            int i = partition(source,start,end);
            quickSort(source,start,i-1);
            quickSort(source,i+1,end);
        }
    }

    public int partition(int[] source,int start,int end){
        int temp = source[end];
        int i = start-1;
        for(int j =start;j<=end-1;j++){
            if(source[j]<=temp){
                swap(source,++i,j);
            }
        }
        swap(source,++i,end);
        return i;
    }

    public static void main(String[] args) {
        FastSort insertSort = new FastSort();
        int[] source = new int[]{1, 8, 7, 5, 4, 2, 7, 5};
        insertSort.sort(source);
        insertSort.output(source);
        source = new int[]{10, 8, 7, 5, 4, 20, 7, 5};
        insertSort.sort(source);
        insertSort.output(source);
        source = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        insertSort.sort(source);
        insertSort.output(source);
    }

}
