package cn.crawin.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergePX {

    public void mergeSort(int[] a){
        int[] tmpa = new int[a.length];
        mergeSort(a, tmpa, 0, a.length-1);
    }

    public void mergeSort(int[] a, int[] tmpa, int left, int right){
        if (left < right){
            int center = (left+right) / 2;
            mergeSort(a, tmpa, left, center);
            mergeSort(a, tmpa, center+1, right);
            merge(a, tmpa, left, center+1, right);
        }
    }

    public void merge(int[] a, int[] tmpa, int lp, int rp, int re){
        int le = rp -1;
        int tp = lp;
        int numEle =  re - lp + 1;

        while ( lp <= le && rp <= re){
            if ( a[lp] <= a[rp] )
                tmpa[tp++] = a[lp++];
            else
                tmpa[tp++] = a[rp++];
        }

        while (lp <= le)
            tmpa[tp++] = a[lp++];

        while (rp <= re)
            tmpa[tp++] = a[rp++];

        for (int i=0; i < numEle; i++, re--)
            a[re] = tmpa[re];

        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test(){
        int[] a = {5,0,8,9,11,3,1,2};
        mergeSort(a);
    }
}
