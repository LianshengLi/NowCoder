package main.Sort;

public interface Sort {
    void sort(Comparable[] a);
    default boolean less(Comparable v, Comparable w)    {  return v.compareTo(w) < 0;  }
    default void exch(Comparable[] a, int i, int j)    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }
}
