import java.util.*;

public class FindDuplicateNumber {
    private static void findDuplicateUsingLoops(int[] arr) {
        ArrayList<Integer> duplicatesList = new ArrayList<>();
         for (int i = 0;i< arr.length;i++){
            for (int j =i+1;j< arr.length;j++){
                if (arr[i] == arr[j]){
                    duplicatesList.add(arr[j] );
                }
            }
        }
        System.out.println("duplicatesList: "+duplicatesList);
    }

    private static void findDuplicateUsingMap(int[] arr) {
        Map<Integer,Integer> map =  new HashMap<>();
        for (int i :arr) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>1){
                System.out.println("duplicate data is: "+entry.getKey());
            }

        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,7};
        findDuplicateUsingLoops(arr);
        findDuplicateUsingMap(arr);



    }



}
