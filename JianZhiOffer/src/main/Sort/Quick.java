package main.Sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Quick implements Sort{
    @Override
    public void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //当范围内只剩一个元素的时候return（大小为1的子数组不需要继续切分）
        if(hi <= lo) return;
        //返回基线
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, lo + 1, j);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i], v)) if(i == hi) break;//只有a[++i]大于时才继续走；相等的时候会停下来（在a[++i]大于等于v时停下）
            while (less(v, a[--j])) if(j == lo) break;//只有v小于a[--j]时才继续走下去；相等的情况会停下来并会跳出循环所以是不稳定排序（在a[--j]小于等于v时停下）
            if(i >= j ) break;
            exch(a, i , j);
        }
        exch(a, lo , j);
        return j;
    }
}