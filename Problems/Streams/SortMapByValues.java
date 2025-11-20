package Streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValues {

    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("Math", 98);
        stringIntegerHashMap.put("ENG", 90);
        stringIntegerHashMap.put("Science", 99);
        stringIntegerHashMap.put("Hindi", 91);
        stringIntegerHashMap.put("Social", 88);
        stringIntegerHashMap.put("Kannada", 89);

        HashMap<String, Integer> stringIntegerHashMap1 = sortByValue(stringIntegerHashMap);
        for (Map.Entry<String, Integer> en : stringIntegerHashMap1.entrySet()) {
            System.out.println(en.getKey() + " " + en.getValue());
        }
        System.out.println("Reversed");
        HashMap<String, Integer> stringIntegerHashMapReverse = sortByValueInReverse(stringIntegerHashMap);
        for (Map.Entry<String, Integer> en : stringIntegerHashMapReverse.entrySet()) {
            System.out.println(en.getKey() + " " + en.getValue());
        }
    }

    // function to sort hashmap by values
    static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        HashMap<String, Integer> temp = hm.entrySet().stream().sorted((i1, i2) ->
                i1.getValue().compareTo(i2.getValue())).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
        ));

        return temp;
    }

    static HashMap<String, Integer> sortByValueInReverse(HashMap<String, Integer> hm) {
        LinkedHashMap<String, Integer> temp = hm.entrySet().stream().sorted(
                        (i1, i2) -> i2.getValue().compareTo(i1.getValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return temp;
    }


}
