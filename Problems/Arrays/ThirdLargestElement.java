package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ThirdLargestElement {

    public static int thirdLargestUsingSorting (int [] arr){
        int thirdLargestElement;
        Arrays.sort(arr);
        thirdLargestElement = arr[arr.length-3];
        System.out.println("Third largest element using thirdLargestUsingSorting is : "+ thirdLargestElement);
        return thirdLargestElement;
    }

    public static int thirdLargestUsingThreeLoops(int [] arr) {
        int n = arr.length;

        // Find the first maximum element.
        int first = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > first)
                first = arr[i];
        }
//        Find the second largest element
        int second = Integer.MIN_VALUE;
        for (int i =0 ; i< arr.length; i++){
            if (arr[i] > second  && arr[i] < first)
                second = arr[i];
        }

//        Find the third largest element
        int third = Integer.MIN_VALUE;
        for (int i =0; i< arr.length ; i++){
            if (arr[i] > third && arr[i]< second)
                third = arr[i];
        }

        // Return the third largest element
        System.out.println("Third largest element using thirdLargestUsingThreeLoops is : "+ third);
        return third;

    }

    public static int thirdLargestUsingSingleLoop(int[] arr){
        int firstLargest = Integer.MIN_VALUE , secondLargest =  Integer.MIN_VALUE, thirdLargest =  Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++){
            if (arr[i] > firstLargest){
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i] >secondLargest){
                thirdLargest = secondLargest;
                secondLargest = arr[i];
            } else if (arr[i] > thirdLargest) {
                thirdLargest = arr[i];
            }
        }
        System.out.println("Third largest element using thirdLargestUsingSingleLoop is : "+ thirdLargest);
        return thirdLargest;
    }

    public static int thirdlargestUsingJava8(int [] arr){
        int thirdlargest = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(-1);
        System.out.println("Third largest element using thirdlargestUsingJava8 is : "+ thirdlargest);
        return thirdlargest;
    }
    public static void main(String[] args) {
        int[] arr = {1, 14, 2, 16, 10, 20};
        thirdLargestUsingSorting(arr);
        thirdLargestUsingThreeLoops(arr);
        thirdLargestUsingSingleLoop(arr);
        thirdlargestUsingJava8(arr);
    }
    
}
