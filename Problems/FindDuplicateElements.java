import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateElements {

//    Given:
//    List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 1, 6);
//    Find all duplicate numbers.
//    Follow-up: Solve it using:
//    HashSet
//    Java Streams
//    Without extra space

    public static List<Integer> findDuplicateUsingHashSet(List<Integer> intList) {
        Set<Integer> set = new HashSet();
        List<Integer> duplicates = new ArrayList<>();

        for (Integer i : intList) {
            if (set.contains(i)) {
                duplicates.add(i);
            } else {
                set.add(i);
            }
        }
        System.out.println("duplicates using findDuplicateUsingHashSet: " + duplicates);
        return duplicates;
    }

    public static List<Integer> findDuplicateUsingStreamsHashSetWay(List<Integer> intList) {
//        Method 1 using the hashset
        Set<Integer> set = new HashSet<>();
        List<Integer> collected = intList.stream()
                .filter(n -> !set.add(n)) // set.add(n) means keep this no if addition to set failed
                .collect(Collectors.toList());
        System.out.println("duplicates using findDuplicateUsingStreams: " + collected);
        return collected;
    }


    public static List<Integer> findDuplicateUsingStreamsFrequencyWay(List<Integer> intList) {
//        Method 2 using the frequency method
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set1 = intList.stream()
                .filter(i -> Collections.frequency(intList, i) > 1)
                .collect(Collectors.toSet());
        duplicates.addAll(set1);
        System.out.println("duplicates using findDuplicateUsingStreams: " + duplicates);

        return duplicates;
    }


    public static List<Integer> findDuplicateWithoutExtraSpace(List<Integer> integerList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
//            int index = Math.abs(integerList)
            if (integerList.get(i).equals(integerList.get(i - 1))) {
//                if (result.add(integerList.get()))
            }
        }
        System.out.println(integerList.get(4));
//        integerList[0];
        return null;
    }

    public static List<Integer> findDuplicateUsingMapWay(List<Integer> intList){
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer,Integer> frequencymap = new HashMap<>();
        for (Integer i :intList){
            frequencymap.put(i, frequencymap.getOrDefault(i,0)+1);
        }

        for (int number: frequencymap.keySet()){
            if (frequencymap.get(number) !=1){
                duplicates.add(number);
            }
        }
        System.out.println("duplicates using findDuplicateUsingMapWay: "+ duplicates);
        return duplicates;
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 7, 6, 7, 8, 8, 9);
        findDuplicateUsingHashSet(integerList);
        findDuplicateUsingStreamsHashSetWay(integerList);
        findDuplicateUsingStreamsFrequencyWay(integerList);
        findDuplicateUsingMapWay(integerList);
//        findDuplicateWithoutExtraSpace(integerList);
    }
}
