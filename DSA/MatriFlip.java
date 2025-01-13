package java_collection.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatriFlip {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(112, 42, 83, 119));
        matrix.add(Arrays.asList(56, 125, 56, 49));
        matrix.add(Arrays.asList(15, 78, 101, 43));
        matrix.add(Arrays.asList(62, 98, 114, 108));

        System.out.println("max sum of flipped matrix is" + flippingMattrix(matrix));
        System.out.println("max sum of flipped matrix is" + flippingMattrixByStremFlatMap(matrix));
    }

    private static int flippingMattrixByStremFlatMap(List<List<Integer>> matrix) {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Inplementing by flippingMattrixByStremFlatMap");
        List<Integer> sortedMatrix = matrix.stream()
                .flatMap(List::stream)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedMatrix);
        System.out.println(sortedMatrix.stream().limit(matrix.size()).toList());
        return sortedMatrix.stream()
                .limit(matrix.size())
                .mapToInt(Integer::intValue)
                .sum();

    }

    private static int flippingMattrix(List<List<Integer>> matrix) {
        System.out.println("\n");
        System.out.println("Inplementing by flippingMattrix");
        int n = matrix.size() / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(2 * n - 1 - j)),
                        Math.max(matrix.get(2 * n - 1 - i).get(j), matrix.get(2 * n - 1 - i).get(2 * n - 1 - j)));
                System.out.println(matrix.get(i).get(j)+","+matrix.get(i).get(2 * n - 1 - j)+","+matrix.get(2 * n - 1 - i).get(j)+","+matrix.get(2 * n - 1 - i).get(2 * n - 1 - j)+", max:"+temp);
                sum+=temp;
            }
        }
        return sum;
    }
}
