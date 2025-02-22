package java_collection.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
//       Convert to upperCase
//        List<String> lowerCaseList = new ArrayList<>(Arrays.asList("madhu", "love", "money"));
//        List<String> upperCaseList = lowerCaseList.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
//        System.out.println(lowerCaseList);
//        System.out.println("to");
//        System.out.println(upperCaseList);

//        filter even number from the list
        List<Integer> intList = Stream.iterate(0, n -> n + 1).limit(21).skip(1).toList();
        List<Integer> evenList = intList.stream().filter(n -> n%2==0).toList();
        System.out.println(intList +"\n"+ evenList);
    }
}
