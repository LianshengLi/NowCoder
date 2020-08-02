package main.Sort;

import java.util.Collection;
import java.util.Collections;

public class Quick implements Sort{
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, lo + 1, j);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i], v)) if(i == hi) break;
            while (less(v, a[--j])) if(j == lo) break;
            if(i >= j ) break;
            exch(a, i , j);
        }
        exch(a, lo , j);
        return j;
    }
}