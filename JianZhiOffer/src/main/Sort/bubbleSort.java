package main.Sort;

public class bubbleSort {
    private int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean Flag = false; // 是否发生交换。没有交换，提前跳出外层循环
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    Flag = true;
                }
            }
            //如何这次扫描发现没有任何元素交换就代表是有序的因此结束循环
            if (!Flag)
            {
                break;
            }
        }
        return array;
    }
}
