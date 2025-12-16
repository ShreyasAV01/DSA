package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestElement {

    public static int getSecondLargestUsingNativeApproach(int[] arr) {
        if (arr.length <2) return -1;
        int secondLargest = -1;

//      sorting the elements to get largest
        Arrays.sort(arr);
        int largest = arr[arr.length -1];
//      starting from length-2 element as last element is largest
        for (int i = arr.length -2; i>=0 ; i--  ){
            if (arr[i] <largest)
                System.out.println("Second largest value using getSecondLargestUsingNativeApproach is :"+arr[i]);
                return arr[i];
        }
        System.out.println("Second largest value using getSecondLargestUsingNativeApproach is :"+secondLargest);
        return -1;
    }


    //        Two search pass
    public static int getSecondLargestUsingBetterApproach(int[] arr) {
        int largest = -1, secondLargest = -1;
        int length = arr.length;

//        finding largest elemnt
        for (int i = 0; i < length; i++) {
            if (largest < arr[i])
                largest = arr[i];
        }

//        finding second largest element
        for (int i = 0; i < length; i++) {
            if (arr[i] > secondLargest && arr[i] != largest)
                secondLargest = arr[i];
        }
        System.out.println("Second largest value using getSecondLargestUsingBetterApproach is :"+secondLargest);
        return secondLargest;
    }


    //        One search pass
    public static int getSecondLargestUsingOptimalApproach(int[] arr) {
        int secondLargest = -1, largest = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] >secondLargest) {
                secondLargest = arr[i];
            }

        }
        System.out.println("Second largest value using getSecondLargestUsingOptimalApproach is :"+secondLargest);
        return secondLargest;
    }

    public static int getSecondLargestUsingJava8Approach(int[] arr) {
        int secondLargest = Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Second largest value using getSecondLargestUsingJava8Approach is :" + secondLargest);
        return secondLargest;
    }
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        getSecondLargestUsingNativeApproach(arr);
        getSecondLargestUsingBetterApproach(arr);
        getSecondLargestUsingOptimalApproach(arr);
        getSecondLargestUsingJava8Approach(arr);
    }
}
