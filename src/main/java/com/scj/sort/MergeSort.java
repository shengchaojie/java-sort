package com.scj.sort;

/**
 * 归并排序
 * @author 10064749
 * @description ${DESCRIPTION}
 * @create 2018-08-07 13:56
 */
public class MergeSort extends AbstractSort {


    @Override
    public void sort(int[] source) {
        sort(source, 0, source.length - 1);
    }

    public void sort(int[] source, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(source, left, middle);
            sort(source, middle + 1, right);
            merge(source, left, middle, right);
        }
    }

    public void merge(int[] source, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int leftFirst = left;
        int leftSecond = middle + 1;
        while (leftFirst <= middle || leftSecond <= right) {
            if (leftFirst > middle && leftSecond <= right) {
                temp[index++] = source[leftSecond++];
                continue;
            }
            if (leftSecond > right && leftFirst <= middle) {
                temp[index++] = source[leftFirst++];
                continue;
            }
            if (source[leftFirst] < source[leftSecond]) {
                temp[index++] = source[leftFirst++];
            } else {
                temp[index++] = source[leftSecond++];
            }
        }
        for(int i = 0;i<temp.length;i++){
            source[left++] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort insertSort = new MergeSort();
        int[] source = new int[]{1, 8, 7, 5, 4, 2, 7, 5};
        insertSort.sort(source);
        insertSort.output(source);
        source = new int[]{10, 8, 7, 5, 4, 20, 7, 5};
        insertSort.sort(source);
        insertSort.output(source);
    }
}
