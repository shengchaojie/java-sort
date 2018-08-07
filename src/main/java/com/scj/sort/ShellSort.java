package com.scj.sort;

import java.util.Random;

/**
 * Created by shengchaojie on 2018/8/7.
 */
public class ShellSort extends AbstractSort{

    public void sort(int[] source) {
        int step =0;
        while ((step*3+1)<source.length){
            step =step*3+1;
        }
        step=1;
        while (step>0){
            for (int i =step;i<source.length;i=i+step){
                int target =i;
                //寻找插入位置
                for (int j =i;j>0;j=j-step){
                    if(source[i]<source[j-step]){
                        target = j-step;
                    }
                }
                if(target!=i){
                    int temp =source[i];
                    for (int k =i;k>target;k=k-step){
                        source[k]=source[k-step];
                    }
                    source[target]=temp;
                }
            }
            step = (step-1)/3;
        }
    }

    public static void main(String[] args) {
        ShellSort insertSort = new ShellSort();
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
