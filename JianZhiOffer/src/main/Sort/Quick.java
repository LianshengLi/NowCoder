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
        /**改进1
         * 切换到插入排序 和大多数递归排序算法一样，改进快速排序性能的一个简单办法基于以下两点:
         *  对于小数组，快速排序比插入排序慢;
         *  因为递归，快速排序的 sort() 方法在小数组中也会调用自己。 因此，在排序小数组时应该切换到插入排序。简单地改动算法 2.5 就可以做到这一点:将
         * sort() 中的语句
         * if (hi <= lo) return;
         *   替换成下面这条语句来对小数组使用插入排序:
         * if (hi <= lo + M) { Insertion.sort(a, lo, hi); return; }
         * 转换参数 M 的最佳值是和系统相关的，但是 5 ~ 15 之间的任意值在大多数情况下都能令人满意
         */
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i], v)) if(i == hi) break;//只有a[++i]小于v时才继续走；相等的时候会停下来（在a[++i]大于等于v时停下）
            while (less(v, a[--j])) if(j == lo) break;//只有v小于a[--j]时才继续走下去；相等的情况会停下来并会跳出循环所以是不稳定排序（在a[--j]小于等于v时停下）
            //两指针重合break；
            if(i >= j ) break;
            exch(a, i , j);
        }
        exch(a, lo , j);
        return j;
    }
}