package java_collection.StreamApi;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {
    public static void main(String[] args) {
//       Convert to upperCase
//        List<String> lowerCaseList = new ArrayList<>(Arrays.asList("madhu", "love", "money"));
//        List<String> upperCaseList = lowerCaseList.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
//        System.out.println(lowerCaseList);
//        System.out.println("to");
//        System.out.println(upperCaseList);

//        filter even number from the list
//        List<Integer> intList = Stream.iterate(0, n -> n + 1).limit(21).skip(1).toList();
//        List<Integer> evenList = intList.stream().filter(n -> n%2==0).toList();
//        System.out.println(intList +"\n"+ evenList);

//        find first element greater then 10
//        List<Integer> list = new ArrayList<>(Arrays.asList(5, 9, 12, 15, 3));
//        Integer firstNumGreaterThen10 = list.stream().filter(f -> f>10).limit(1).toList().get(0);
//        System.out.println(firstNumGreaterThen10);
//        list.stream().filter(f -> f>10).findFirst().ifPresent(System.out::println);

//        Sort a List of Strings
//        List<String> lowerCaseList = new ArrayList<>(Arrays.asList("madhu", "love", "money"));
//        lowerCaseList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::print);

//        Count Elements Greater than 50
//        List<Integer> numbers = Arrays.asList(10, 55, 60, 25, 80);
//        Stream<Integer> greaterThen50 = numbers.stream().filter(f -> f > 50);
//        System.out.println(greaterThen50.count());

//        Find Maximum and Minimum Value
//        List<Integer> numbers = Arrays.asList(3, 10, 7, 1, 9);
//        System.out.println(numbers.stream().min((a, b) -> a-b).get());
//        System.out.println(numbers.stream().max(Integer::compareTo).get());

//        Sum of All Elements
//        List<Integer> numbers = Arrays.asList(3, 5, 8, 10);
//        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());

//        Group Names by Length
//        List<String> names = Arrays.asList("Alice", "Bob", "David", "Eve");
//        Map<Integer, List<String>> lengthGroupName = names.stream().collect(Collectors.groupingBy(String::length));
//        System.out.println(lengthGroupName);

//        Find Duplicate Elements
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5);
//        Set<Integer> set = numbers.stream()
//                .collect(Collectors.groupingBy(f -> f, Collectors.counting()))
//                .entrySet().stream()
//                .filter(f -> f.getValue() > 1)
//                .map(Map.Entry::getKey).collect(Collectors.toSet());
//        System.out.println(set);

//        Convert List to Map
//        List<Employee> employees = Arrays.asList(
//                new Employee(1, "John"),
//                new Employee(2, "Jane"),
//                new Employee(3, "Mike")
//        );
//        Map<Integer, String> employeMap = employees.stream().collect(Collectors.toMap(f -> f.id, f -> f.name));
//        System.out.println(employeMap);

//        Find Second Highest Number
//        List<Integer> numbers = Arrays.asList(10, 20, 15, 25, 30);
//        System.out.println(numbers.stream().sorted((a,b)->b-a).skip(1).findFirst().get());

//        Flatten a List of Lists
//        List<List<Integer>> listOfLists = Arrays.asList(
//                Arrays.asList(1, 2, 3),
//                Arrays.asList(4, 5),
//                Arrays.asList(6, 7, 8)
//        );
//        System.out.println(listOfLists.stream().flatMap(List::stream).collect(Collectors.toList()));

//        Find the Longest String in a List
//        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");
//        System.out.println(words.stream().max((a,b) -> a.length()- b.length()).get());
//        System.out.println(words.stream().max((a,b) -> Integer.compare(b.length(), a.length())).get());

//        Parallel Stream Usage - Time Comparison
//        List<Integer> numbers = new ArrayList<>();
//        Random random = new Random();
//
//        IntStream.range(0, 10_00_000).forEach(n -> numbers.add(random.nextInt(1000)));
//
//        long startTime = System.currentTimeMillis();
//        long sumSequential = numbers.stream().mapToInt(Integer::intValue).sum();
//        long endTime = System.currentTimeMillis();
//        System.out.println("Sequential Stream Sum: " + sumSequential + " | Time: " + (endTime - startTime) + "ms");
//
//        startTime = System.currentTimeMillis();
//        long sumParallel = numbers.parallelStream().mapToInt(Integer::intValue).sum();
//        endTime = System.currentTimeMillis();
//        System.out.println("Parallel Stream Sum: " + sumParallel + " | Time: " + (endTime - startTime) + "ms");

//        Parallel Stream Usage - Time Comparison when value range is 10_00_000_000
//        Random random = new Random(23);
//        long startTime = System.currentTimeMillis();
//        long sumSequential = LongStream.range(0,10_00_000_000L)
//                .map(n -> random.nextInt(100_000)).sum();
//        long endTime = System.currentTimeMillis();
//        System.out.println("Sequential Stream Sum: " + sumSequential + " | Time: " + (endTime - startTime) + "ms");
//
//        System.out.println("starting parallel");
//        startTime = System.currentTimeMillis();
//        long sumParallel = LongStream.range(0, 10_00_000_000L)
//                .parallel()
//                .map(n -> ThreadLocalRandom.current().nextInt(100_000))
//                .sum();
//        endTime = System.currentTimeMillis();
//        System.out.println("Parallel Stream Sum: " + sumParallel + " | Time: " + (endTime - startTime) + "ms");

//        Find the Most Frequent Element in a List
//        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5);
//        int frequent = numbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .get().getKey();
//        System.out.println(frequent);

//        find common from two list
//        List<Integer> numbers1 = Arrays.asList(3, 10, 7, 1, 9);
//        List<Integer> numbers2 = Arrays.asList(1, 10, 2, 3, 3, 3, 4, 7, 5, 5, 5);
//        List<Integer> commonList = numbers1.stream()
//                .filter(numbers2 :: contains)
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(commonList);

//        print all prime numbers between 1 and 100
//        IntStream.rangeClosed(2, 100).filter(StreamApi::isPrime).forEach(System.out::println);

//        reverse int list
//        List<Integer> numbers = Arrays.asList(3, 10, 7, 1, 9);
//        List<Integer> result = numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
//            Collections.reverse(list);
//            return list;
//        }));
//        System.out.println(result);

//        Print name from list that starts with 'A'
//        List<String> names = Arrays.asList("Alice", "Alya", "Bob", "David", "Eve");
//        names.stream().filter(n -> n.startsWith("A")).forEach(System.out::printf);
//        System.out.println(names.stream().filter(n -> n.startsWith("A")).collect(Collectors.joining(", ")));

//         Print every char of all string
//        List<String> names = Arrays.asList("Alice", "Alya", "Bob", "David", "Eve");
//        System.out.println(names.stream().map(m->m.split("")).collect(Collectors.toList()));
//        System.out.println(names.stream().map(m-> m.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));

//        Sum of all int
//        List<Integer> numbers = Arrays.asList(3, 10, 7, 1, 9);
//        System.out.println(numbers.stream().reduce(0,Integer::sum));

//        list to map
//        List<String> names = Arrays.asList("Alice", "Alya", "Bob", "David", "Eve");
//        System.out.println(names.stream().collect(Collectors.toMap().toMap(n->n,String::length)));

//        list to map count duplicate
//        List<String> names = Arrays.asList("Alice", "Alya", "Bob", "David", "Eve", "Alice");
//        Map<String, Integer> nameCounts1 = names.stream()
//                .collect(Collectors.toMap(
//                        name -> name,
//                        name ->1,
//                        Integer::sum,
//                        LinkedHashMap::new));

//        findFirst vs findAny
//        List<String> names = Arrays.asList("Alice", "Alya", "Bob", "David", "Eve", "Alice");
//        System.out.println(names.stream().findFirst());
//        System.out.println(names.parallelStream().findAny());

//        forEach vs forEachOrdered
//        names.stream().forEachOrdered(System.out::println);
//        System.out.println("----------------------------");
//        names.parallelStream().forEach(System.out::println);

//        how to group
//        List<String> names = Arrays.asList("Alice", "Alya", "Bob", "David", "Eve", "Alice");
//        System.out.println(names.stream().collect(Collectors.groupingBy(n->n.charAt(0))));

//        remove special character from email
//        String email = "madhusudankryd!.1997@gma!il.com";
//        System.out.println("previous email is"+email);
//        System.out.println("after removal of special char"+email.chars()
//                .mapToObj(c->String.valueOf((char)c))
//                .filter(c->c.matches("[a-zA-Z0-9@.]"))
//                .collect(Collectors.joining()));
    }

    private static boolean isPrime(int i) {
        if (i <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(i)).allMatch(n -> i % n != 0);
    }
}

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

