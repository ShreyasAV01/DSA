package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesInList {

    public static void main (String [] args){
        List<Integer> stringList =  Arrays.asList(1,2,4,5,3,6,5,8,9);

        List<Integer> collected = stringList.stream().distinct().toList();

        System.out.println("OriginalList: "+stringList);
        System.out.println("collected list: "+collected);
    }
}
