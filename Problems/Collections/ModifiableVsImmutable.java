package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModifiableVsImmutable {
    public static void main(String args[]){
        List<Integer> modifiableList = new ArrayList<>(5);

        modifiableList.add(0);


        List<Integer> unmodifiableList = Collections.unmodifiableList(modifiableList);
        List<Integer> immutableList = Collections.unmodifiableList(new ArrayList<Integer>(modifiableList));
        System.out.println("Initial modifiableList  :  "+modifiableList);
        System.out.println("Initial unmodifiableList :  "+unmodifiableList);
        System.out.println("Initial immutableList :  "+immutableList);

//        Adding elements to the collection
        try{
            unmodifiableList.add(1);
        } catch (UnsupportedOperationException e){
            System.out.println("cant modify UnmodifiableList");
        }
        try{
            immutableList.add(1);
        } catch (UnsupportedOperationException e){
            System.out.println("cant modify immutableList");
        }

        modifiableList.add(2);
        System.out.println("After adding element to modifying list the value of modifiable list is: "+modifiableList);
        System.out.println("After adding element to modifying list the value of unmodifiable list is: "+unmodifiableList);
        System.out.println("After adding element to modifying list the value of immutable list is: "+immutableList);


    }
}
