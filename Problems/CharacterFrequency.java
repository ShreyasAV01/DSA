import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    //    Given:    "springboot"
//    Return:    s=1    p=1    r=1    i=1    n=1    g=1    b=1    o=2    t=1
    public static void main(String[] args) {
        String str = "springboot";
        System.out.println("Original String : " + str);
        findCharacterFrequencyUsingHashMap(str);
        findCharacterFrequencyUsinglinkedHashMap(str);
        findCharacterFrequencyUsingGetOrDefault(str);
        findCharacterFrequencyUsingStreams(str);
    }


    public static void findCharacterFrequencyUsingHashMap(String str) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (char element : str.toCharArray()) {
            characterMap.put(element, characterMap.getOrDefault(element, 0) + 1);
        }

        System.out.print("findCharacterFrequencyUsingHashMap :- ");
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.print(entry.getKey() + " = " + entry.getValue() + "  ");
        }

//    Time: O(n)
//    Space: O(k) where k = number of distinct characters
    }


    private static void findCharacterFrequencyUsinglinkedHashMap(String str) {
        Map<Character, Integer> characterMap = new LinkedHashMap<>();

        for (char element : str.toCharArray()) {
            characterMap.put(element, characterMap.getOrDefault(element, 0) + 1);
        }

        System.out.println("");System.out.print("findCharacterFrequencyUsinglinkedHashMap :- ");
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.print(entry.getKey() + " = " + entry.getValue() + "  ");
        }
    }

    public static void findCharacterFrequencyUsingGetOrDefault(String str){
        Map<Character,Integer> characterFreqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            characterFreqMap.put(ch , characterFreqMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println(" ");
        System.out.print("findCharacterFrequencyUsingGetOrDefault :- ");
        characterFreqMap.forEach((key,value) -> System.out.print( key + " = " + value +"  "));

    }


    public static void findCharacterFrequencyUsingStreams(String str){
        LinkedHashMap<Character, Long> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println();
        System.out.print("findCharacterFrequencyUsingStreams :- ");
        collect.forEach((key, value) -> System.out.print(key+ " = "+ value +"  "));


    }

}
