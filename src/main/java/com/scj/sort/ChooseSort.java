package com.scj.sort;

/**
 * Created by shengchaojie on 2018/8/7.
 */
public class ChooseSort extends AbstractSort{



    public void sort(int[] source) {
        for (int i =0 ;i <source.length;i++){
            int smallest = i;
            for (int j=i+1;j<source.length;j++){
                if (source[j] < source[smallest]) {
                    smallest = j;
                }
            }
            swap(source,i,smallest);
        }
    }

    public static void main(String[] args) {
        ChooseSort insertSort = new ChooseSort();
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
