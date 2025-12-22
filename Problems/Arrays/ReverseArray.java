package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {


    public static void reverseArrayUsingInBuiltMethod(int[] arr){

        List<Integer> list = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
        Collections.reverse(list);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.print("Reversed using reverseArrayUsingInBuiltMethod ");
        for (int i= 0; i< array.length; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
    public static void reverseArrayUsingTempArray(int[] arr){
        int length = arr.length;
        int[] temp = new int[length];

//        copying elements from original to temp array
        for (int i = 0; i < arr.length; i++){
            temp[i]= arr[length-i-1];
        }

//      copying elements from temp array back to original array
        for (int i= 0; i < arr.length; i++){
            arr[i] =temp[i];
        }
//      Printing the reversed array
        System.out.println("Reverse array using the temp array is: ");
        for (int i=0 ;i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void reverseUsingTwoPointer(int[] arr){
        int left =0, right = arr.length-1;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        left++;
        right--;
        }

//      Printing the reversed array
        System.out.println("Reverse array using the TwoPointer is: ");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


    public static void reverseArrayBySwappingElements(int[] arr){
        for (int i=0; i< arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        //      Printing the reversed array
        System.out.println("Reverse array BySwappingElements is: ");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2, 3, 4, 5, 6};
         reverseArrayUsingInBuiltMethod(arr);
         reverseArrayUsingTempArray(arr2);
         reverseUsingTwoPointer(arr3);
         reverseArrayBySwappingElements(arr1);
    }
}
