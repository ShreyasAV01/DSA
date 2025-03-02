package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestStringInList {
    public static void main (String args[]){
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> newList = new ArrayList<String>();

        list.add("adas");
        list.add("adasas");
        list.add("as");

        findLongestUsingLambda(list);
        findLongestUsingMethodReference(newList);
    }

//    USING LAMBDA
    public static void findLongestUsingLambda(List<String> list){
        Optional<String> max = list.stream().max(Comparator.comparing(i -> i.toString().length()));
        System.out.println("Longest number using lambda");
        max.ifPresentOrElse(System.out::println, () -> System.out.println("N/A"));
    }
    public static void findLongestUsingMethodReference(List<String> list){
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("Longest number using method ref");
        max.ifPresentOrElse(System.out::println, () ->System.out.println("N/A"));

    }

}
