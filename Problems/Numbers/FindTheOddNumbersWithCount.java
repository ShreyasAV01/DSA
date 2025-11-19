package Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTheOddNumbersWithCount {
    private static void getOddNumbersWithFrequency(List<Integer> list){
        List<Integer> oddList = list.stream().filter(i -> i % 2 != 0).toList();
        Map<Integer, Long> collected = oddList.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        collected.forEach((number,count) -> System.out.printf("Number %d appears %d time(s)%n", number, count));
    }
    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 7, 5);
        getOddNumbersWithFrequency(inputList);
    }
}
