package cn.crawin.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序
 */
public class JiShuPX {

    public void radixSort(int[] a, int d){
        int divide = 1;
        int radix = 10;
        int len = a.length;
        int[] tmp = new int[len];
        int[] count = new int[radix];

        for (int i=0; i < d; i++){
            System.arraycopy(a, 0, tmp, 0, len);
            Arrays.fill(count, 0);

            for (int j=0; j < len; j++){
                int tempKey = (tmp[j]/divide) % radix;
                count[tempKey]++;
            }

            for (int j=1; j < radix; j++)
                count[j] += count[j-1];

            for (int j = len-1; j >= 0; j--){
                int tempKey = (tmp[j]/divide) % radix;
                count[tempKey]--;
                a[count[tempKey]] = tmp[j];
            }

            divide = divide * radix;
        }
        System.out.println(Arrays.toString(a));
    }


    @Test
    public void test(){
        int[] a = {23, 89, 13, 859, 9, 1007, 257618, 953, 26};
        radixSort(a, 6);
    }
}
