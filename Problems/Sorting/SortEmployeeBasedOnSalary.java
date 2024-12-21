package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeeBasedOnSalary {

    static class Employee{
        String name;
        Integer salary;

        public String getName() {
            return name;
        }

        public Employee(String name, Integer salary) {
            this.name = name;
            this.salary = salary;
        }

        public Integer getSalary() {
            return salary;
        }
    }

    static class EmployeeComparator implements Comparator<Employee>{


        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSalary()-o2.getSalary();
        }

    }
    static class EmployeeComparatorBasedOnSalaryAndName implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {

            int salaryComparison = o1.getSalary().compareTo(o2.getSalary());
            if (salaryComparison != 0) {
                return salaryComparison;  // If salaries are different, return the result
            }
            return  o1.getName().compareTo(o2.getName());
        }

    }

    private static void sortEmployees(List<Employee> empList){
        Collections.sort(empList,new EmployeeComparatorBasedOnSalaryAndName());
        System.out.println("Sorting using java comparator");
        for (Employee emp: empList) {
            System.out.println("Employee Name: "+ emp.getName()+ "Salary: {}"+emp.getSalary() );
        }

    }
    private static void sortEmployeeUsingJava8(List<Employee> empList){
        empList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println("Sorting using java 8");
        for (Employee emp: empList) {
            System.out.println("Employee Name: "+ emp.getName()+ "Salary: {}"+emp.getSalary() );
        }

    }
    public static void main(String[] args) {
        Employee e1 = new Employee("pavan",900000);
        Employee e2 = new Employee("punit",800000);
        Employee e4 = new Employee("punia",800000);
        Employee e3 = new Employee("suresh",1000000);

        List<Employee> employeeList= new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        sortEmployees(employeeList);
        sortEmployeeUsingJava8(employeeList);

    }
}
