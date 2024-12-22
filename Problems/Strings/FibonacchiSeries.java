package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static Integer getFibonacciUsingRecursion(Integer limit){
        Map<Integer,Integer> integerMap = new HashMap<>();

        if (integerMap.containsKey(limit)){
            return integerMap.get(limit);
        }

        if (limit ==0 ) return 0;
        if (limit ==1 ) return 1;

        int result = getFibonacciUsingRecursion(limit - 1) + getFibonacciUsingRecursion(limit - 2);
        integerMap.put(limit,result);
        return result;
    }

    private static void printFibonacciSeriesUsingRecursion(Integer limit){
        List<Integer> integerList = new ArrayList<>();
        for (int i =0; i<limit; i++){
            Integer result = getFibonacciUsingRecursion(i);
            integerList.add(result);
        }
        System.out.print("Fibonacci Series using recursion is : "+integerList);
    }


    public static void main(String[] args) {
        getFibonacciUsingDynamicProgramming(10);
        printFibonacciSeriesUsingRecursion(10);

    }

}
