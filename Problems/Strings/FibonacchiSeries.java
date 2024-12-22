package Strings;

import java.util.ArrayList;
import java.util.List;

public class FibonacchiSeries {

    private static void getFibonacciUsingDynamicProgramming(Integer limit){
        List<Integer> fibonacchiIntList = new ArrayList<>();
        Integer numOne =0;
        Integer numTwo =1;

        fibonacchiIntList.add(0,numOne);
        fibonacchiIntList.add(0,numTwo);

        for (int i =2; i<=limit; i++){
            fibonacchiIntList.add(i, fibonacchiIntList.get(i-1) + fibonacchiIntList.get(i-2));
        }
        System.out.println("Fibonacci Series is : "+fibonacchiIntList);
    }
    public static void main(String[] args) {
        getFibonacciUsingDynamicProgramming(10);

    }

}
