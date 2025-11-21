package Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequencyOfOccurrence {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 78, 9, 1, 2, 5, 33, 3, 3, 5, 7);
        HashMap<Integer, Integer> freqHashmap = new HashMap<>();

        for (Integer  i:  integerList){
            freqHashmap.put(i, freqHashmap.getOrDefault(i,0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry: freqHashmap.entrySet()) {
            System.out.println("Element "+ entry.getKey() + " Frequency "+entry.getValue());
        }


    }
}
