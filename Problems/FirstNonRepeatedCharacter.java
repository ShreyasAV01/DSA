import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
//"swiss"
//    Return:
//            "w"
//    Follow-up: What is the time and space complexity?

    public static void main(String[] args) {
        String s = "swiss";
        System.out.println("Original string : "+s);
        findFirstNonRepeatedCharacterUsingIndexOfLastIndexOf(s);
        findFirstNonRepeatedCharacterUsingHashMapWay(s);
        findFirstNonRepeatedCharacterUsingLinkedHashMapWay(s);
        findFirstNonRepeatedCharacterUsingStreams(s);
        findFirstNonRepeatedCharacterUsingStreamsIndexOf(s);
    }

    private static void findFirstNonRepeatedCharacterUsingLinkedHashMapWay(String str) {
        Map<Character, Integer> characterFreqMap = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            characterFreqMap.put(c, characterFreqMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : characterFreqMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("findFirstNonRepeatedCharacterUsingLinkedHashMapWay :" + entry.getKey());
                break;
            }

        }

//        Time complexity: O(n)
//        Space complexity: O(k), where k is the number of distinct characters
    }

    private static void findFirstNonRepeatedCharacterUsingHashMapWay(String str) {
        Map<Character, Integer> characterFreqMap = new HashMap();

        for (char c : str.toCharArray()) {
            characterFreqMap.put(c, characterFreqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (characterFreqMap.get(c) == 1) {
                System.out.println("findFirstNonRepeatedCharacterUsingHashMapWay :" + c);
                break;
            }
        }

//        Time: O(n)
//        Space: O(k), where k = number of distinct characters
    }

    private static void findFirstNonRepeatedCharacterUsingIndexOfLastIndexOf(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                System.out.println("findFirstNonRepeatedCharacterUsingIndexOfLastIndexOf : " + c);
                break;
            }
        }

//        Time: O(n²)     Space: O(1)
    }


    private static void findFirstNonRepeatedCharacterUsingStreams(String str){

        Character character = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("findFirstNonRepeatedCharacterUsingStreams : "+ character);

//       Time:  O(n) Space:  O(k) space.
    }

    private static void findFirstNonRepeatedCharacterUsingStreamsIndexOf(String str){
        Character character = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
                .findFirst()
                .orElse(null);
        System.out.println("findFirstNonRepeatedCharacterUsingStreamsIndexOf : "+character);
    }
}
