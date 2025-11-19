package Streams;

import java.util.Arrays;
import java.util.List;

public class KthSmallestElement {

    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1, 2, 3, 7, 5, 7, 8, 6, 5);
        int k = 5;

        Integer kthElement = integerList.stream().sorted().distinct().toList().get(k-1);

        System.out.println("kth smallest Element in list:  "+integerList+" is: "+kthElement);

    }
}
