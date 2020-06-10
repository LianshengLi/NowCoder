package main;
public class ArrayProblems {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 用例:
     * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
     */

    public boolean Find(int target, int [][] array) {
        //处理边界条件

        if(array == null || array.length == 0)
            return false;
        int arrayRowCount = array.length;
        int arrayCloumnCount = array[0].length;
        int normRowIndex = arrayRowCount -1;
        int normCloumnIndex = 0;

        while(normRowIndex >= 0 && normCloumnIndex < arrayCloumnCount){
            if(target > array[normRowIndex][normCloumnIndex]){
                normCloumnIndex++;
            }
            else if(target < array[normRowIndex][normCloumnIndex]){
                normRowIndex --;
            }
            else
                return true;
        }
        return false;
    }

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers== null || numbers.length==0) return false;
        int[] duplicatedNums = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            duplicatedNums[numbers[i]]++;
        }
        for (int j = 0; j < length; j++) {
            if(duplicatedNums[j] >= 2){
                duplication[0] = j;
                return true;
            }
        }
        return false;
    }
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     */
    public int[] multiply(int[] A) {
        //length = n
        if(A == null || A.length== 0){
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < B.length ; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;       
        for (int j = B.length-2; j >= 0  ; j--) {
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }

}
