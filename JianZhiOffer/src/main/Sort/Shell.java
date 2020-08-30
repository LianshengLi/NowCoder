package main.Sort;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Shell implements Sort{
    //在进行排序时，如果h很大，我们就能将元素移动到很远的地方，为实现更小的h有序创造方便
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, h - h);
                }
            }
            h = h / 3;
        }
    }
}
