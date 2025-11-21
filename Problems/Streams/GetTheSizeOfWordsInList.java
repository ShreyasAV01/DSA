package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class GetTheSizeOfWordsInList {
//    Write a Java program to convert a List of Strings to a Map,
//    where each element in the List is a key in the Map, and the value for each key is the length
//    of the corresponding String.

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("I", "am", "unstoppable");
        HashMap<String, Integer> mpp = new HashMap<>();

        for (String word : lst) {
            mpp.put(word, word.length());
        }

        for (Map.Entry entry : mpp.entrySet()) {
            System.out.println(entry.getKey() + " ----  size : " + entry.getValue());
        }
// Using java 8
        Map<String, Integer> collect = lst.stream().collect(Collectors.toMap(s -> s, String::length));
        System.out.println("Using java 8 streams");
        for (Map.Entry entry : collect.entrySet()) {
            System.out.println(entry.getKey() + " ----  size : " + entry.getValue());
        }

    }
}
