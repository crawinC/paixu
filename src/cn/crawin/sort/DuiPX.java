package cn.crawin.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序
 */
public class DuiPX {

    public void heapSort(int[] a){
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--){
            percDown( a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--){
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            percDown(a, 0, i-1);
        }
        System.out.println(Arrays.toString(a) );
    }

    public void percDown(int[] a, int i, int len) {
        int j;
        int tmp = a[i];
        for (j = 2*i; j < len; j *= 2){
            if (j < len && a[j] < a[j+1])
                ++j;
            if (tmp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = tmp;
    }

    @Test
    public void test(){
        int[] a = {5,0,8,9,11,3,1,2};
        heapSort(a);
    }
}
