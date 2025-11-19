package Streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestNumberInArray {



    public static void main(String[] args) {
        List<Integer> integerList =  Arrays.asList(1,2,4,32,5,78,3,6,5,8,9);

        Integer integer = integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.print("Second largest value is "+integer);

    }

}
