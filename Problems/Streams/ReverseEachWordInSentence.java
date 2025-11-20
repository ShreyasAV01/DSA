package Streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseEachWordInSentence {

    public static void main(String[] args) {
        String str = "I hate debugging someones code";

        String[] split = str.split(" ");
        List<String> collect = Arrays.stream(split)
                .map((word) -> new StringBuilder(word).reverse()
                        .toString()).collect(Collectors.toList());


        System.out.println("reversed order string is " + collect);

    }
}
