import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
//"swiss"
//    Return:
//            "w"
//    Follow-up: What is the time and space complexity?

    public static void main(String[] args) {
        String s = "swiss";
        findFirstNonRepeatedCharacterUsingIndexOfLastIndexOf(s);
        findFirstNonRepeatedCharacterUsingHashMapWay(s);
        findFirstNonRepeatedCharacterUsingLinkedHashMapWay(s);
    }

    private static void findFirstNonRepeatedCharacterUsingLinkedHashMapWay(String str) {
        Map<Character, Integer> characterFreqMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            characterFreqMap.put(c, characterFreqMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : characterFreqMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("findFirstNonRepeatedCharacterUsingLinkedHashMapWay :" + entry.getKey());
                break;
            }

        }
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
    }

    private static void findFirstNonRepeatedCharacterUsingIndexOfLastIndexOf(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                System.out.println("findFirstNonRepeatedCharacterUsingIndexOfLastIndexOf : " + c);
                break;
            }
        }
    }
}
