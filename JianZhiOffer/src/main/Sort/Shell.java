package main.Sort;

public class Shell implements Sort{
    //在进行排序时，如果h很大，我们就能将元素移动到很远的地方，为实现更小的h有序创造方便
    //希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的。这样的数组被称为 h 有序数组
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1){
            //// 1, 4, 13, 40, 121, 364, 1093, ...
            //将数组变为h有序
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, h - h);
                }
            }
            h = h / 3;
        }
    }
}
