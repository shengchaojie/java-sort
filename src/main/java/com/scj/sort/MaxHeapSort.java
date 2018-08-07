package com.scj.sort;

import java.io.FileReader;

/**
 * 堆排序
 * O(nlog(n))
 * Created by shengchaojie on 2018/8/7.
 */
public class MaxHeapSort extends AbstractSort{

    public void sort(int[] source) {
        buildHeap(source);
        for (int i = source.length-1;i>0;i--){
            swap(source,0,i);
            maxHeapify(source,0,i);
        }
    }

    public void buildHeap(int[] source){
        for (int i =source.length/2-1;i>=0;i--){
            maxHeapify(source,i,source.length);
        }
    }


    public void maxHeapify(int [] source,int root,int heapSize){
        int left = 2*(root+1)-1;
        int right = 2*(root+1);
        int largest = root;
        if(heapSize>left&&source[left]>source[root]){
            largest = left;
        }
        if(heapSize>right&&source[right]>source[largest]){
            largest = right;
        }
        if(largest!=root){
            swap(source,largest,root);
            maxHeapify(source,largest,heapSize);
        }
    }

    public static void main(String[] args) {
        MaxHeapSort insertSort = new MaxHeapSort();
        int[] source = new int[]{1, 8, 7, 5, 4, 2, 7, 5,1,10};
        insertSort.sort(source);
        insertSort.output(source);
        source = new int[]{10, 8, 7, 5, 4, 20, 7, 5,56,66,100,78};
        insertSort.sort(source);
        insertSort.output(source);
        source = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        insertSort.sort(source);
        insertSort.output(source);
    }
}
