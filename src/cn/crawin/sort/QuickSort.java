package cn.crawin.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public void swap(int[] a, int i, int i1) {
        int value = a[i];
        a[i] = a[i1];
        a[i1] = value;
    }

    // 分治法
    // 递归实现
    public void quick_sort1(int s[], int l, int r){
        if(l < r){
            int i = l, j = r, x = s[l];
            while (i < j){
                while (i < j && s[j] >= x)
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x){
                    i++;
                }

                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort1(s, l, i-1);
            quick_sort1(s, i+1, r);

            System.out.println(Arrays.toString(s));
        }
    }

    /**
     * 非递归实现(先进后出)
     */
    public void quick_sort2(int[] a, int start, int end){
        Stack<Integer> stack = new Stack<>();
        if(start < end){
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()){
                int l = stack.pop();
                int r = stack.pop();
                int index = partition2(a, l, r);
                if (l < index-1){
                    stack.push(index-1);
                    stack.push(l);
                }
                if (r > index+1){
                    stack.push(r);
                    stack.push(index+1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private int partition2(int[] a, int start, int end) {
        int pivot = a[start];
        while (start < end){
            while (start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while (start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }

    /**
     * 三路划分法
     * @param a
     * @param left
     * @param right
     */
    public void quick_sort3(int[] a, int left, int right){
        if (right <= left)
            return;

        int p, q, i, j;
        int pivot;
        i = p = left;
        j = q = right - 1;

        pivot = a[right];
        while (true){
            while (i < right && a[i] <= pivot){
                if (a[i] == pivot){
                    swap(a, i, p);
                    p++;
                }
                i++;
            }

            while (left <= j && a[j] >= pivot){
                if (a[j] == pivot){
                    swap(a, j, q);
                    q--;
                }
                j--;
            }

            if (i >= j)
                break;

            swap(a, i, j);
            i++;
            j--;
        }

        i--;
        p--;
        while (p >= left){
            swap(a, i, p);
            i--;
            p--;
        }

        j++;
        q++;
        while (q <= right){
            swap(a, j, q);
            j++;
            q++;
        }

        quick_sort3(a, left, i);
        quick_sort3(a, j, right);

    }


    @Test
    public void test(){
        int[] a = {5,0,8,9,11,3,1,2};
        //quick_sort1(a, 0 , a.length-1);
        //quick_sort2(a, 0, a.length-1);
        //quick_sort3(a, 0, a.length-1);
    }
}
