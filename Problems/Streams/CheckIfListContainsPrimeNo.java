package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CheckIfListContainsPrimeNo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 78, 9);
        boolean b = list.stream().anyMatch(num -> num > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(num)).allMatch(div -> num % div != 0));
        System.out.println("Is Prime: " + b);
    }
}
