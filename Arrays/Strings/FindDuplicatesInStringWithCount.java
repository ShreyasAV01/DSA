package Strings;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInStringWithCount {

    private static void findDuplicate(String str){
        char[] charArray = str.toLowerCase().replaceAll("\\s", "").toCharArray();
        Map<Character,Integer> charMap = new HashMap<>();

        for (char key: charArray) {
            if (charMap.containsKey(key)){
                charMap.put(key,charMap.get(key) + 1);
            }else {
                charMap.put(key,1);
            }
        }

        charMap.entrySet().removeIf( i -> i.getValue()==1);
        System.out.println(charMap);

    }
    public static void main(String[] args) {
        String str = "A sample string data";
        findDuplicate(str);
    }
}
