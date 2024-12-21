package Strings;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateWordsInStringWithCount {
    private static void findDuplicateWords(String str){
        String[] split = str.toLowerCase().split(" ");

        Map<String,Integer> stringIntegerMap =  new HashMap<>();
        for (String word:split) {
            if (stringIntegerMap.containsKey(word)){
                stringIntegerMap.put(word, stringIntegerMap.get(word)+1);
            }else {
                stringIntegerMap.put(word, 1);
            }
        }
        stringIntegerMap.entrySet().removeIf( j -> j.getValue()==1);
        System.out.println(stringIntegerMap);

    }
    public static void main(String[] args) {
        String str = "Iam a java developer and iam  also interested in C++,I have about 6 years experience in Java as a developer";
        findDuplicateWords(str);
    }
}
