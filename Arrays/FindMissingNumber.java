//        Given an array arr[] of size N-1 with integers in the range of [1, N], the task is to find the missing number from the first N integers.
//                Note: There are no duplicates in the list.
//        Input: arr[] = {1, 2, 4, 6, 3, 7, 8} , N = 8
//        Output: 5
//        Explanation: Here the size of the array is 8, so the range will be [1, 8]. The missing number between 1 to 8 is 5

public class FindMissingNumber {

    public static int missingNumber(int n,int[] arr ){
//        Using sum of n formula
        int sum = 0;
        int missingNumber;
        for (int num :  arr) {
            sum+=num;
        }
        int expectedSum = (n*(n+1))/2;
        missingNumber = expectedSum-sum;
        System.out.println("missingNumber: "+missingNumber);
        return  missingNumber;

    }
    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,7,8,9,1};
        int n = 10;
        missingNumber(n,arr);

    }
}