package com.scj.sort;

/**
 * 冒泡排序
 * 最大的数放到最后面
 * 时间复杂度O(n²)
 * @author 10064749
 * @description ${DESCRIPTION}
 * @create 2018-08-07 11:14
 */
public class BubbleSort extends AbstractSort {


    @Override
    public void sort(int[] source) {
        int length = source.length;
        for (int i = 0; i < length; i++) {
           for(int j=0 ; j<length-i-1;j++){
               if(source[j]>source[j+1]){
                   swap(source,j,j+1);
               }
           }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] source = new int[]{1, 8, 7, 5, 4, 2, 7, 5};
        bubbleSort.sort(source);
        bubbleSort.output(source);
        source = new int[]{10, 8, 7, 5, 4, 20, 7, 5};
        bubbleSort.sort(source);
        bubbleSort.output(source);
        source = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        bubbleSort.sort(source);
        bubbleSort.output(source);
    }

}
