package cn.crawin.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class XEpx {

    public void xepx(int []a){
        int j;

        for (int gap = a.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < a.length; i++){
                int tmp = a[i];
                for (j = i; j >= gap && tmp < a[j-gap]; j -= gap){
                    a[j] = a[j-gap];
                }
                a[j] = tmp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test(){
        int[] a = {5,0,8,9,11,3,1,2};
        xepx(a);
    }
}
