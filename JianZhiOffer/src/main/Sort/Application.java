package main.Sort;

public class Application {
    public static void main(String[] args) {
        Sort sort = new Quick();
        Comparable[] comparables = {'a', 'd','b'};
        sort.sort(comparables);
        for (int i = 0; i < comparables.length; i++) {
            System.out.print(comparables[i]);
        }
    }
}
