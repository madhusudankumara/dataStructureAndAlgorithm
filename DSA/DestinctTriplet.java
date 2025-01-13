package java_collection.DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DestinctTriplet {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(3, 3, 4, 7, 8));
        int d = 5;
        System.out.println("number of Triplets = " + getDestinctTriplet(list, d));
    }

    private static int getDestinctTriplet(List<Integer> list, int d) {
        int len = list.size(), count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if((list.get(i)+list.get(j)+list.get(k))%d==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
