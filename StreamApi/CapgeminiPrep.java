package java_collection.StreamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CapgeminiPrep {
    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 11);
        List<Integer> numList1 = Arrays.asList(13, 14, 45);

        List<String> lines = List.of("a,b,c", "d,e", "f");

        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "", null);

        List<List<Integer>> listOfList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Employ> empList = Arrays.asList(
                new Employ(1, "nishank", 27),
                new Employ(2, "ankit", 26),
                new Employ(3, "Mrigank", 34)
        );


//        even number from list
//        List<Integer> evenList = numList.stream().filter(x -> x % 2 == 0).toList();
//        System.out.println(evenList);

//        Maximum number in list
//        int max = numList.stream().max((x, y) -> x - y).get();
//        System.out.println(max);
//        Optional<Integer> max1 = numList.stream().max(Integer::compareTo);
//        max1.ifPresent(System.out::println);
//        OptionalInt max2 = numList1.stream().mapToInt(Integer::intValue).max();
//        System.out.println(max2);
//        Optional<Integer> max3 = numList.stream().sorted(Collections.reverseOrder()).limit(1).findFirst();
//        max3.ifPresent(System.out::println);

//        Sum of all element in list
//        int sum = numList.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);
//        Optional<Integer> sum1 = numList.stream().reduce((x, y)->x+y);
//        sum1.ifPresent(System.out::println);
//        Optional<Integer> sum2 = numList.stream().reduce(Integer::sum);
//        sum2.ifPresent(System.out::println);

//        Convert list of string to uppercase
//        List<String> upList = stringList.stream().map(x -> x.toUpperCase()).toList();
//        System.out.println(upList);
//        List<String> upList1 = stringList.stream().map(String::toUpperCase).toList();
//        Stream.concat(lines.stream(),stringList.stream()).toList();

//        group element in list by length
//        Map<Integer,List<String>> group = stringList.stream().collect(Collectors.groupingBy(String::length));
//        System.out.println(group);

//        Flaten list of list in single list
//        List<Integer> list = listOfList.stream().flatMap(x -> x.stream()).toList();
//        System.out.println(list);
//        List<Integer> list1 = listOfList.stream().flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(list1);
//        List<Integer> list2 = listOfList.stream().flatMap(List::stream).sorted(Collections.reverseOrder()).collect(Collectors.toList());
//        System.out.println(list2);
//        List<Integer> list3 = listOfList.stream().flatMap(List::stream).collect(Collectors.toList()).reversed();
//        System.out.println(list3);

//        lines.stream().flatMap(line->Arrays.stream(line.split(","))).toList();

//        remove duplicate from list
//        List<Integer> distinct = numList.stream().distinct().toList();
//        System.out.println(distinct);
//        Set<Integer> set = numList.stream().collect(Collectors.toSet());
//        System.out.println(set);

//        Average numbers in list
//        Optional<Integer> sum = numList.stream().reduce(Integer::sum);
//        sum.ifPresent(x->System.out.println(sum.get()/numList.size()));
//        OptionalDouble avg = numList.stream().mapToInt(Integer::intValue).average();
//        System.out.println(avg);

//        check if all element in list are positive
//        boolean pos = numList.stream().allMatch(n->n>0);

//        find first number greater than 10
//        Optional<Integer> num = numList.stream().filter(n -> n > 10).findFirst();
//        num.ifPresent(System.out::println);

//        merge two list
//        List<Integer> concat = Stream.concat(numList.stream(), numList1.stream()).toList();
//        System.out.println(concat);
//        int concatSum = Stream.concat(numList.stream(), numList1.stream()).toList().reversed().stream().mapToInt(Integer::intValue).sum();
//        System.out.println(concatSum);

//        sort the list of employ on the basic of age
//        empList.stream().sorted((x,y)->x.age- y.age).collect(Collectors.toList()).forEach(e-> System.out.println(e.name));
//        List<Employ> sortedEmp = empList.stream().sorted((x,y)->x.age- y.age).collect(Collectors.toList());
//        sortedEmp.stream().forEach(n-> System.out.println(n.name));
//        String string = sortedEmp.stream().map(Employ::getName).collect(Collectors.joining(","));
//        System.out.println(string);

//        calculate product of all element
//        Optional<Integer> product = numList.stream().reduce((x, y)->x*y);
//        product.ifPresent(System.out::println);

//        count occurance of element
//        Map<Integer, Long> count = numList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(count);

//        Longest string in list
//        List<String> emp = empList.stream().map(e -> e.name).collect(Collectors.toList()); //[nishank, ankit, Mrigank]
//        System.out.println(emp);
//        Optional<String> emp1 = emp.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst();
//        System.out.println(emp1);
//        String lgEmp = emp.stream().max(Comparator.comparingInt(String::length)).orElse("No word found");
//        System.out.println(lgEmp);

//        if any number greater then 8
//        List<Integer> naturalNumber = Stream.iterate(0,n->n+1).limit(10).collect(Collectors.toList());
//        boolean num = naturalNumber.stream().anyMatch(n->n>8);
//        System.out.println(num);

//        list of string into single list
//        String joining = stringList.stream().collect(Collectors.joining(","));
//        System.out.println(joining);

//        create map where the key is id and value is name
//        Map<Integer, String> empMap = empList.stream().collect(Collectors.toMap(Employ::getId, Employ::getName));
//        System.out.println(empMap);

//        remove empty or null string from the list
//        List<String> strList = stringList.stream().filter(x -> x != null && !x.equals("")).collect(Collectors.toList());
//        System.out.println(strList);
//        List<String> strList1 = stringList.stream().filter(Objects::nonNull).filter(x -> !x.equals("")).collect(Collectors.toList());
//        System.out.println(strList1);


    }

    static class Employ {
        int id;
        String name;
        int age;

        Employ(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getId() {
            return id;
        }
    }
}
