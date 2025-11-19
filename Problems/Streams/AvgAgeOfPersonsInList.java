package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AvgAgeOfPersonsInList {

    public static void main (String[] args){
        List<Person> peopleList = new ArrayList<>();
        Person p1 =  new Person("Abhimanyu",21);
        Person p2 =  new Person("Arjuna",20);
        Person p3 =  new Person("Ekalavya", 25);

        peopleList.add(p1);
        peopleList.add(p2);
        peopleList.add(p3);

        double averageAge1 = peopleList.stream().mapToInt(Person::getAge).average().orElse(0);
peopleList.stream().collect(Collectors.averagingInt(Person::getAge));
peopleList.stream().mapToInt(Person::getAge).average();
        double v = peopleList.stream().map(Person::getAge).reduce(0, Integer::sum) / (double) peopleList.size();
        Double averageAge2 = peopleList.stream().collect(Collectors.averagingInt(Person::getAge));

        double averageAge3 = peopleList.stream().map(Person::getAge).reduce(0, Integer::sum) / (double) peopleList.size();

        System.out.println("averageAge1 is: "+averageAge1);
        System.out.println("averageAge2 is: "+averageAge2);
        System.out.println("averageAge3 is: "+averageAge3);

    }

    static class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name=name;
            this.age=age;
        }
        public int getAge() {
            return age;
        }

    }
}
