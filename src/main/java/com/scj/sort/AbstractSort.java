package com.scj.sort;

import java.util.concurrent.AbstractExecutorService;

/**
 * @author 10064749
 * @description ${DESCRIPTION}
 * @create 2018-08-07 11:41
 */
public abstract class AbstractSort {

    public void output(int[] source) {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

    public void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    public abstract void sort(int[] source);

}
