package com.scj.sort;

/**
 * 插入排序
 * 类似洗扑克牌
 * 时间复杂度O(n²)
 * @author 10064749
 * @description ${DESCRIPTION}
 * @create 2018-08-07 11:59
 */
public class InsertSort extends AbstractSort {

    @Override
    public void sort(int[] source) {
        int length = source.length;
        for (int i = 0; i < length; i++) {
            int target = -1;
            for (int j = i; j>0; j--) {
                if(source[i]<source[j-1]){
                    target =j -1;
                }
            }
            if(target!=-1){
                int temp = source[i];
                for(int k = i;k>target;k--){
                    source[k] =source[k-1];
                }
                source[target]=temp;
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] source = new int[]{1, 8, 7, 5, 4, 2, 7, 5};
        insertSort.sort(source);
        insertSort.output(source);
        source = new int[]{10, 8, 7, 5, 4, 20, 7, 5};
        insertSort.sort(source);
        insertSort.output(source);
    }
}
